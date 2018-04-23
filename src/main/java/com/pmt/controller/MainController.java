package com.pmt.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.RequestHeaderMapMethodArgumentResolver;
import org.springframework.web.servlet.ModelAndView;

import com.pmt.dao.TestDao;
import com.pmt.dao.TestDaoImpl;
import com.pmt.model.Account;
import com.pmt.model.Businessunit;
import com.pmt.model.Certificate;
import com.pmt.model.Client;
import com.pmt.model.Deliveryunit;
import com.pmt.model.Location;
import com.pmt.model.Project;
import com.pmt.model.Region;
import com.pmt.model.Resource;
import com.pmt.model.ResourceRequest;
import com.pmt.model.Skill;
import com.pmt.model.Visa;
import com.pmt.service.AccountService;
import com.pmt.service.BusinessunitService;
import com.pmt.service.ClientService;
import com.pmt.service.DeliveryunitService;
import com.pmt.service.LocationService;
import com.pmt.service.ManageResReqService;
import com.pmt.service.ProjectService;
import com.pmt.service.RegionService;
import com.pmt.service.ResourceService;
import com.pmt.service.SkillService;
import com.pmt.service.TestService;
import com.pmt.service.TestServiceImpl;
import com.pmt.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	@Qualifier("projectServiceImpl")
	public ProjectService projectService;
	
	@Autowired
	@Qualifier("skillServiceImpl")
	public SkillService skillService;
	
	@Autowired
	@Qualifier("clientServiceImpl")
	public ClientService clientService;
	
	@Autowired
	@Qualifier("regionServiceImpl")
	public RegionService regionService;
	
	@Autowired
	@Qualifier("locationServiceImpl")
	public LocationService locationService;
	
	@Autowired
	@Qualifier("businessunitServiceImpl")
	public BusinessunitService businessunitService;
	
	@Autowired
	@Qualifier("deliveryunitServiceImpl")
	public DeliveryunitService deliveryunitService;
	
	@Autowired
	@Qualifier("resourceServiceImpl")
	public ResourceService resourceService;
	
	@Autowired
	@Qualifier("accountServiceImpl")
	public AccountService accountService;
	
	@Autowired
	@Qualifier("manageResReqServiceImpl")
	private ManageResReqService manageResReqService;
	
	@Autowired
	@Qualifier(value="userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier(value="testServiceImpl")
	private TestService testService;
	
	/**************************************************************************************************************/
	/*******************************************Common Handler Mapping methods*************************************/

	@RequestMapping(value="/login" , method = RequestMethod.GET)
	public ModelAndView login(){
		
		ModelAndView mvc =  new ModelAndView();
		mvc.setViewName("login");
		return mvc;
	}
	
    @RequestMapping(value="/test", method=RequestMethod.GET)
	public void test(){
		testService.testServiceMethod1();
		//testService.testServiceMethod2();
	}
	
	@RequestMapping(value="/verifylogin", method=RequestMethod.POST)
	public ModelAndView verifyLogin(@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session){		
		
		ModelAndView modelAndView = new ModelAndView();
		if(userService.validateUser(username, password)){
			 session.setAttribute("username", username);
			 session.setAttribute("resourceId", userService.getUserResourceId(username));			 
			 modelAndView.setViewName("home");
		}		
		
		else{			
			modelAndView.setViewName("login");			
		}
		return modelAndView;	
	}
	
	
	@RequestMapping(value="/systemmaint", method=RequestMethod.GET)
	public String systemMaintHome(){	
		
		
		
		return "systemmaint-admin";
	}
	
	@RequestMapping(value="/projectmanagement", method=RequestMethod.GET)
	public String projectManagement(){		
		/*Retrieve the details of the resource/user from the session and 
		display the same on the below view.*/
		return "projectmanagementhome";
	}
	
	
	
	
	
	/**************************************************************************************************************/
	/*********************************Project Controller Handler methods*******************************************/
	//Project related handler mappings
	@RequestMapping(value="/projects", method=RequestMethod.GET)
	public ModelAndView projectMaint(){
		
		List<Project> projects =  projectService.listProjects();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("projects", projects);
		modelAndView.setViewName("projects");
		return modelAndView;
	}
	
	@RequestMapping(value="/editproject/{projectid}" , method=RequestMethod.GET)
	public ModelAndView returnProjectEditForm(@PathVariable("projectid") int projectId){
		Project project =  projectService.getProjectById(projectId);
		List<Resource> managers = resourceService.listResources();
		List<Location> locations = locationService.listLocations();
		List<Account> accounts = accountService.listAccounts();		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("project",project);
		modelAndView.addObject("managers",managers);
		modelAndView.addObject("locations", locations);
		modelAndView.addObject("accounts", accounts);		
		modelAndView.setViewName("editprojectform");
		return modelAndView;
	}
	
	@RequestMapping(value="/editingproject/{projectid}", method=RequestMethod.POST)
	public String editingProject(@PathVariable("projectid") int id,
			@RequestParam("name") String name,
			@RequestParam("desc") String desc,
			@RequestParam("type") String type,
			@RequestParam("location") int locationId,
			@RequestParam("psd") String psd,
			@RequestParam("ped") String ped,
			@RequestParam("contracttype") String contracttype,
			@RequestParam("manager") int managerId,
			@RequestParam("account") int accountId,
			@RequestParam("status") String status
			){
		Project project = projectService.getProjectById(id);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		project.setName(name);
		project.setDesc(desc);
		project.setType(type);
		project.setContractType(contracttype);
		project.setLocation(locationService.getLocationById(locationId));
		project.setManager(resourceService.getResourceById(managerId));
		project.setAccount(accountService.getAccountById(accountId));
		project.setStatus(status);
		
		try {
			project.setStartDate(formatter.parse(psd));
			project.setEndDate(formatter.parse(ped));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	
		projectService.updateProject(project);
		return "success";
	}
	
	
	@RequestMapping(value="/addproject", method=RequestMethod.GET)
	public ModelAndView returnProjectForm(){
		List<Resource> managers = resourceService.listResources();
		List<Location> locations = locationService.listLocations();
		List<Account> accounts = accountService.listAccounts();
		ModelAndView modelAndView =  new ModelAndView();
		modelAndView.addObject("managers", managers);
		modelAndView.addObject("locations", locations);
		modelAndView.addObject("accounts", accounts);
		modelAndView.setViewName("addprojectform");
		return modelAndView;
	}
	
	@RequestMapping(value="/addingproject", method=RequestMethod.POST)
	public String addingProject(@RequestParam("name") String name,
			@RequestParam("desc") String desc,
			@RequestParam("type") String type,
			@RequestParam("location") int locationId,
			@RequestParam("psd") String psd,
			@RequestParam("ped") String ped,
			@RequestParam("contracttype") String contracttype,
			@RequestParam("manager") int managerId,
			@RequestParam("account") int accountId,
			@RequestParam("status") String status
			){
		Project project = new Project();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		project.setName(name);
		project.setDesc(desc);
		project.setType(type);
		project.setContractType(contracttype);
		project.setLocation(locationService.getLocationById(locationId));
		project.setManager(resourceService.getResourceById(managerId));
		project.setAccount(accountService.getAccountById(accountId));
		project.setStatus(status);
		
		try {
			project.setStartDate(formatter.parse(psd));
			project.setEndDate(formatter.parse(ped));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	
		projectService.addProject(project);
		return "success";
	}
	
	
	/**************************************************************************************************************/
	/*********************************Skill Controller Handler methods*******************************************/
	//Skill related handler mappings
	@RequestMapping(value="/skills", method=RequestMethod.GET)
	public ModelAndView skillMaint(){
		
		List<Skill> skills =  skillService.listSkills();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("skills", skills);
		modelAndView.setViewName("skills");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/addskill", method=RequestMethod.GET)
	public String returnSkillForm(){
		
		return "addskillform";
	}
	
	@RequestMapping(value="/addingskill", method=RequestMethod.POST)
	public String adddingSkill(@ModelAttribute("skill") Skill skill){
		skillService.addSkill(skill);
		return "success";
	}
	
	@RequestMapping(value="/searchskill", method=RequestMethod.GET)
	public String returnSkillSearchForm(){
		
		return "searchskillform";
	}
	
	
	@RequestMapping(value="/searchingskill", method=RequestMethod.POST)
	public ModelAndView searchingSkill(@RequestParam("searchbynameorid") String searchCrit, 
			@RequestParam("searchvalue") String searchValue)
	{
		List<Skill> skills = new ArrayList<Skill>();
		if(searchCrit.equalsIgnoreCase("skillid"))
			skills = skillService.getSkillsById(Integer.parseInt(searchValue));
		else
			skills = skillService.getSkillsByName(searchValue);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchskillform");
		modelAndView.addObject("skills", skills);
		return modelAndView;
	}
	
	@RequestMapping(value="/editskill/{skillid}" , method=RequestMethod.GET)
	public ModelAndView returnSkillEditForm(@PathVariable("skillid") int skillId){
		Skill skill =  skillService.getSkillById(skillId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("skill",skill);
		modelAndView.setViewName("editskillform");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/editingskill" , method=RequestMethod.POST)
	public String editingSkill(@ModelAttribute("skill") Skill skill){
		skillService.updateSkill(skill);
		return "success";		
	}
	
	@RequestMapping(value="/removeskill/{skillid}" , method=RequestMethod.GET)
	public String removeSkill(@PathVariable("skillid") int skillId){
		skillService.removeSkill(skillId);
		return "success";
	}
	
	
	


    /**************************************************************************************************************/
	/*********************************Client Controller Handler methods*******************************************/
	//Client related handler mappings
	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public ModelAndView clientMaint(){
		
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("clients");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/addclient", method=RequestMethod.GET)
	public ModelAndView returnClientForm(){
		List<Location> locations = locationService.listLocations();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("locations", locations);
		modelAndView.setViewName("addclientform");
		return modelAndView;
	}
	
	@RequestMapping(value="/addingclient", method=RequestMethod.POST)
	public String addingClient(@RequestParam("name") String name,
			@RequestParam("description") String description,
			@RequestParam("location") String location_city
			){		
		Client client = new Client();
		client.setName(name);
		client.setDescription(description);
		//Location location = locationService.getLocationByCity(location_city);
		Location location = locationService.getLocationByCity(location_city);
		client.setLocation(location);
		clientService.addClient(client);
		return "success";
	}
	
	@RequestMapping(value="/searchclient", method=RequestMethod.GET)
	public String returnClientSearchForm(){
		
		return "searchclientform";
	}
	
	/*@RequestMapping(value="/searchingclient", method=RequestMethod.POST)
	public ModelAndView searchingClient(@RequestParam("searchbynameorid") String searchCrit, 
			@RequestParam("searchvalue") String searchValue)
	{
		List<Client> clients = new ArrayList<Client>();
		if(searchCrit.equalsIgnoreCase("clientid"))
			clients = clientService.getClientsById(Integer.parseInt(searchValue));
		else
			clients = clientService.getClientsByName(searchValue);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchclientform");
		modelAndView.addObject("clients", clients);
		return modelAndView;
	}*/
	
	@RequestMapping(value="/searchingclient", method=RequestMethod.POST)
	public @ResponseBody List<Client> searchingClient(
			@RequestParam("crit") String crit,
			@RequestParam("critval") String critVal
			)
	{
		if(crit.equalsIgnoreCase("id"))
		return clientService.getClientsById(Integer.parseInt(critVal));
		else
			return clientService.getClientsByName(critVal);
			
		
	}
	
	
	@RequestMapping(value="/editclient/{clientid}" , method=RequestMethod.GET)
	public ModelAndView returnClientEditForm(@PathVariable("clientid") int clientId){
		Client client =  clientService.getClientById(clientId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("client",client);
		modelAndView.setViewName("editclientform");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/editingclient" , method=RequestMethod.POST)
	public String editingClient(@ModelAttribute("client") Client client){
		clientService.updateClient(client);
		return "success";		
	}
	
	@RequestMapping(value="/removeclient/{clientid}" , method=RequestMethod.GET)
	public String removeClient(@PathVariable("clientid") int clientId){
		clientService.removeClient(clientId);
		return "success";
	}

	
	/**************************************************************************************************************/
	/*********************************Region Controller Handler methods*******************************************/
	//Region related handler mappings
	@RequestMapping(value="/regions", method=RequestMethod.GET)
	public ModelAndView regionMaint(){
		
		List<Region> regions =  regionService.listRegions();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("regions", regions);
		modelAndView.setViewName("regions");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/addregion", method=RequestMethod.GET)
	public String returnRegionForm(){
		
		return "addregionform";
	}
	
	@RequestMapping(value="/addingregion", method=RequestMethod.POST)
	public String adddingRegion(@ModelAttribute("region") Region region){
		regionService.addRegion(region);
		return "success";
	}
	
	@RequestMapping(value="/searchregion", method=RequestMethod.GET)
	public String returnRegionSearchForm(){
		
		return "searchregionform";
	}
	
	@RequestMapping(value="/searchingregion", method=RequestMethod.POST)
	public ModelAndView searchingRegion(@RequestParam("searchbynameorid") String searchCrit, 
			@RequestParam("searchvalue") String searchValue)
	{
		List<Region> regions = new ArrayList<Region>();
		if(searchCrit.equalsIgnoreCase("regionid"))
			regions = regionService.getRegionsById(Integer.parseInt(searchValue));
		else
			regions = regionService.getRegionsByName(searchValue);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchregionform");
		modelAndView.addObject("regions", regions);
		return modelAndView;
	}
	
	@RequestMapping(value="/editregion/{regionid}" , method=RequestMethod.GET)
	public ModelAndView returnRegionEditForm(@PathVariable("regionid") int regionId){
		Region region =  regionService.getRegionById(regionId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("region",region);
		modelAndView.setViewName("editregionform");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/editingregion" , method=RequestMethod.POST)
	public String editingRegion(@ModelAttribute("region") Region region){
		regionService.updateRegion(region);
		return "success";		
	}
	
	@RequestMapping(value="/removeregion/{regionid}" , method=RequestMethod.GET)
	public String removeRegion(@PathVariable("regionid") int regionId){
		regionService.removeRegion(regionId);
		return "success";
	}

	


/**************************************************************************************************************/
	/*********************************Location Controller Handler methods*******************************************/
	//Location related handler mappings
	@RequestMapping(value="/locations", method=RequestMethod.GET)
	public ModelAndView locationMaint(){
		
		List<Location> locations =  locationService.listLocations();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("locations", locations);
		modelAndView.setViewName("locations");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/addlocation", method=RequestMethod.GET)
	public String returnLocationForm(){
		
		return "addlocationform";
	}
	
	@RequestMapping(value="/addinglocation", method=RequestMethod.POST)
	public String adddingLocation(@ModelAttribute("location") Location location){
		locationService.addLocation(location);
		return "success";
	}
	
	@RequestMapping(value="/searchlocation", method=RequestMethod.GET)
	public String returnLocationSearchForm(){
		
		return "searchlocationform";
	}
	
	@RequestMapping(value="/editlocation/{locationid}" , method=RequestMethod.GET)
	public ModelAndView returnLocationEditForm(@PathVariable("locationid") int locationId){
		Location location =  locationService.getLocationById(locationId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("location",location);
		modelAndView.setViewName("editlocationform");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/editinglocation" , method=RequestMethod.POST)
	public String editingLocation(@ModelAttribute("location") Location location){
		locationService.updateLocation(location);
		return "success";		
	}
	
	@RequestMapping(value="/removelocation/{locationid}" , method=RequestMethod.GET)
	public String removeLocation(@PathVariable("locationid") int locationId){
		locationService.removeLocation(locationId);
		return "success";
	}
	
	



/**************************************************************************************************************/
	/*********************************Businessunit Controller Handler methods*******************************************/
	//BusinessUnit related handler mappings
	@RequestMapping(value="/businessunits", method=RequestMethod.GET)
	public ModelAndView businessunitMaint(){
		
		List<Businessunit> businessunits =  businessunitService.listBusinessunits();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("businessunits", businessunits);
		modelAndView.setViewName("businessunits");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/addbusinessunit", method=RequestMethod.GET)
	public String returnBusinessunitForm(){
		
		return "addbusinessunitform";
	}
	
	@RequestMapping(value="/addingbusinessunit", method=RequestMethod.POST)
	public String adddingBusinessunit(@ModelAttribute("businessunit") Businessunit businessunit){
		businessunitService.addBusinessunit(businessunit);
		return "success";
	}
	
		
	@RequestMapping(value="/editbusinessunit/{businessunitid}" , method=RequestMethod.GET)
	public ModelAndView returnBusinessunitEditForm(@PathVariable("businessunitid") int businessunitId){
		Businessunit businessunit =  businessunitService.getBusinessunitById(businessunitId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("businessunit",businessunit);
		modelAndView.setViewName("editbusinessunitform");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/editingbusinessunit" , method=RequestMethod.POST)
	public String editingBusinessunit(@ModelAttribute("businessunit") Businessunit businessunit){
		businessunitService.updateBusinessunit(businessunit);
		return "success";		
	}
	
	@RequestMapping(value="/removebusinessunit/{businessunitid}" , method=RequestMethod.GET)
	public String removeBusinessunit(@PathVariable("businessunitid") int businessunitId){
		businessunitService.removeBusinessunit(businessunitId);
		return "success";
	}
	
	@RequestMapping(value="/searchbusinessunit", method=RequestMethod.GET)
	public String returnBusinessunitSearchForm(){
		
		return "searchbusinessunitform";
	}
	
	
	@RequestMapping(value="/searchingbusinessunit", method=RequestMethod.POST)
	public ModelAndView searchingBusinessunit(@RequestParam("searchbynameorid") String searchCrit, 
			@RequestParam("searchvalue") String searchValue)
	{
		List<Businessunit> businessunits = new ArrayList<Businessunit>();
		if(searchCrit.equalsIgnoreCase("businessunitid"))
			businessunits = businessunitService.getBusinessunitsById(Integer.parseInt(searchValue));
		else
			businessunits = businessunitService.getBusinessunitsByName(searchValue);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchbusinessunitform");
		modelAndView.addObject("businessunits", businessunits);
		return modelAndView;
	}



    /**************************************************************************************************************/
	/*********************************Deliveryunit Controller Handler methods*******************************************/
	//DeliveryUnit related handler mappings
	@RequestMapping(value="/deliveryunits", method=RequestMethod.GET)
	public ModelAndView deliveryunitMaint(){
		
		List<Deliveryunit> deliveryunits =  deliveryunitService.listDeliveryunits();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("deliveryunits", deliveryunits);
		modelAndView.setViewName("deliveryunits");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/adddeliveryunit", method=RequestMethod.GET)
	public String returnDeliveryunitForm(){
		
		return "adddeliveryunitform";
	}
	
	@RequestMapping(value="/addingdeliveryunit", method=RequestMethod.POST)
	public String adddingDeliveryunit(@ModelAttribute("deliveryunit") Deliveryunit deliveryunit){
		deliveryunitService.addDeliveryunit(deliveryunit);
		return "success";
	}
	
	@RequestMapping(value="/searchdeliveryunit", method=RequestMethod.GET)
	public String returnDeliveryunitSearchForm(){
		
		return "searchdeliveryunitform";
	}
	
	
	@RequestMapping(value="/searchingdeliveryunit", method=RequestMethod.POST)
	public ModelAndView searchingDeliveryunit(@RequestParam("searchbynameorid") String searchCrit, 
			@RequestParam("searchvalue") String searchValue)
	{
		List<Deliveryunit> deliveryunits = new ArrayList<Deliveryunit>();
		if(searchCrit.equalsIgnoreCase("deliveryunitid"))
			deliveryunits = deliveryunitService.getDeliveryunitsById(Integer.parseInt(searchValue));
		else
			deliveryunits = deliveryunitService.getDeliveryunitsByName(searchValue);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchdeliveryunitform");
		modelAndView.addObject("deliveryunits", deliveryunits);
		return modelAndView;
	}
	
	@RequestMapping(value="/editdeliveryunit/{deliveryunitid}" , method=RequestMethod.GET)
	public ModelAndView returnDeliveryunitEditForm(@PathVariable("deliveryunitid") int deliveryunitId){
		Deliveryunit deliveryunit =  deliveryunitService.getDeliveryunitById(deliveryunitId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("deliveryunit",deliveryunit);
		modelAndView.setViewName("editdeliveryunitform");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/editingdeliveryunit" , method=RequestMethod.POST)
	public String editingDeliveryunit(@ModelAttribute("deliveryunit") Deliveryunit deliveryunit){
		deliveryunitService.updateDeliveryunit(deliveryunit);
		return "success";		
	}
	
	@RequestMapping(value="/removedeliveryunit/{deliveryunitid}" , method=RequestMethod.GET)
	public String removeDeliveryunit(@PathVariable("deliveryunitid") int deliveryunitId){
		deliveryunitService.removeDeliveryunit(deliveryunitId);
		return "success";
	}
	
	/**************************************************************************************************************/
	/*********************************Resource Controller Handler methods*******************************************/
	//Resource related handler mappings
	
	@RequestMapping(value="/resources", method=RequestMethod.GET)
	public ModelAndView resourceMaint(){
		
		List<Resource> resources =  resourceService.listResources();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("resources", resources);
		modelAndView.setViewName("resources");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/addresource", method=RequestMethod.GET)
	public ModelAndView returnResourceForm(){
		List<Location> locations = locationService.listLocations();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("locations", locations);
		modelAndView.setViewName("addresourceform");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/viewResource/{id}", method=RequestMethod.GET)
	public ModelAndView returnViewResourceForm(@PathVariable("id") int id ){
		Resource employee = resourceService.getResourceById(id);
		List<Skill> resSkills = new ArrayList<Skill>();
		for(Integer skillId:resourceService.getResourceSkillIds(id)){
			resSkills.add(skillService.getSkillById(skillId));
		}		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employee", employee);
		modelAndView.addObject("resSkills", resSkills);
		modelAndView.setViewName("viewresourceform");
		return modelAndView;
	}
	
	@RequestMapping(value="/addingresource", method=RequestMethod.POST)
	public String addingResource(
			@RequestParam("gender") String gender,
			@RequestParam("maritalstatus") String maritalStatus,
			@RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName,
			@RequestParam("employeeid") String employeeId,
			@RequestParam("designation") String designation,
			@RequestParam("contactnumber") String contactNumber,
			@RequestParam("currentlocation") String currLocation,
			@RequestParam("permanentlocation") String permLocation,
			@RequestParam("tier") String tier,
			@RequestParam("email") String email,
			@RequestParam("doj") String doj,
			@RequestParam("noe") String natureOfEmployment,
			@RequestParam("empstatus") String empStatus,
			@RequestParam("lwd") String lastWorkingDay,
			@RequestParam("csd") String contractStartDate,
			@RequestParam("ced") String contractEndDate,
			@RequestParam("ppexpdt") String passportExpiryDate,
			@RequestParam("passportnumber") String passportNumber,
			@RequestParam("track") String track,
			@RequestParam("competencygroup") String competencyGroup
			
			){
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Resource resource = new Resource();		
		resource.setTier(tier);
		resource.setEmail(email);
		resource.setFirstName(firstName);
		resource.setLastName(lastName);
		resource.setGender(gender);
		resource.setMaritalStatus(maritalStatus);
		resource.setContactNumber(contactNumber);		
		resource.setDesignation(designation);
		resource.setEmployeeId(Integer.parseInt(employeeId));
		resource.setCurrLocation(locationService.getLocationByCity(currLocation));
		resource.setPermLocation(locationService.getLocationByCity(permLocation));
		resource.setNatureOfEmployment(natureOfEmployment);
		resource.setEmpStatus(empStatus);
		resource.setPassportNumber(passportNumber);
		resource.setCompetencyGroup(competencyGroup);
		resource.setTrack(track);
		
		try {
			resource.setDoj(formatter.parse(doj));
			resource.setLastWorkingDay(formatter.parse(lastWorkingDay));
			resource.setContractEndDate(formatter.parse(contractEndDate));
			resource.setContractStartDate(formatter.parse(contractStartDate));
			resource.setPassportExpiryDate(formatter.parse(passportExpiryDate));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
			resourceService.addResource(resource);		
		return "success";
	}
	
	
	@RequestMapping(value="/addcertificate/{id}", method = RequestMethod.GET)
	public ModelAndView returnAddCertificateForm(@PathVariable("id") int id){
		Resource resource = resourceService.getResourceById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("resource", resource);
		modelAndView.setViewName("addcertificateform");
		return modelAndView;
	}
	
	@RequestMapping(value="/addvisa/{id}", method = RequestMethod.GET)
	public ModelAndView returnAddVisaForm(@PathVariable("id") int id){
		Resource resource = resourceService.getResourceById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("resource",resource);
		modelAndView.setViewName("addvisaform");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/addingcertificate/{id}", method = RequestMethod.POST)
	public String addingCertificate(@PathVariable("id") int id,
			@RequestParam Map<String,String> certDetMap			
			){
		Resource resource = resourceService.getResourceById(id);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Certificate cert1 =  new Certificate();
		cert1.setEmployee(resource);
		cert1.setCertifyingOrg(certDetMap.get("certorg0"));
		cert1.setGrade(certDetMap.get("grade0"));
		cert1.setName(certDetMap.get("certname0"));
		cert1.setPercentage(certDetMap.get("marks0"));
		try {
			cert1.setValidTill(formatter.parse(certDetMap.get("validtill0")));
			cert1.setCertDate(formatter.parse(certDetMap.get("certdate0")));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		Certificate cert2 =  new Certificate();
		cert2.setEmployee(resource);
		cert2.setCertifyingOrg(certDetMap.get("certorg1"));
		cert2.setGrade(certDetMap.get("grade1"));
		cert2.setName(certDetMap.get("certname1"));
		cert2.setPercentage(certDetMap.get("marks1"));
		
		try {
			cert2.setValidTill(formatter.parse(certDetMap.get("validtill1")));
			cert2.setCertDate(formatter.parse(certDetMap.get("certdate1")));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}	
		
		
		Set<Certificate> certset = new HashSet<Certificate>();
		certset.add(cert1);
		certset.add(cert2);
		resource.setCertificates(certset);
		resourceService.addResource(resource);	
		
		return "success";
	}
	
	@RequestMapping(value="/addingvisa/{id}", method = RequestMethod.POST)
	public String addingVisa(@PathVariable("id") int id,
			@RequestParam Map<String,String> visaDetMap			
			){
		Resource resource = resourceService.getResourceById(id);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Visa visa1 =  new Visa();
		visa1.setEmployee(resource);
		visa1.setCountry(visaDetMap.get("visacountry0"));
		visa1.setVisaType(visaDetMap.get("visatype0"));
		try {
			visa1.setValidTill(formatter.parse(visaDetMap.get("validtill0")));
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		Visa visa2 =  new Visa();
		visa2.setEmployee(resource);
		visa2.setCountry(visaDetMap.get("visacountry1"));
		visa2.setVisaType(visaDetMap.get("visatype1"));
		try {
			visa2.setValidTill(formatter.parse(visaDetMap.get("validtill1")));
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
			
		
		
		Set<Visa> visaset = new HashSet<Visa>();
		visaset.add(visa1);
		visaset.add(visa2);
		resource.setVisas(visaset);
		resourceService.addResource(resource);	
		
		return "success";
	}
	
	
	@RequestMapping(value="/addresourceskill/{id}", method=RequestMethod.GET)
	public ModelAndView addSkill(@PathVariable("id") int id){
		Resource resource = resourceService.getResourceById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("resource", resource);
		modelAndView.setViewName("addresourceskillform");
		return modelAndView;
		//resourceService.updateResourceSkill();
	}
	
	@RequestMapping(value="/loadresourceskill", method=RequestMethod.POST)
	public @ResponseBody List<Skill> loadResourceSkill(@RequestParam("category") String category){
		
		if(!category.isEmpty())
		return skillService.getSkillsByCategory(category);
		else
			return skillService.listSkills();		
	}
	
	@RequestMapping(value="/addingresourceskill/{id}", method=RequestMethod.POST)
	public String addingResourceSkill(@PathVariable("id") int id,
			@RequestParam Map<String,String> skillDetMap
			){
		resourceService.updateResourceSkill(id, Integer.parseInt(skillDetMap.get("resourceskill0")),
				Integer.parseInt(skillDetMap.get("resourceskillrating0")),
				Boolean.parseBoolean(skillDetMap.get("resourceskillcore0"))
				);
		resourceService.updateResourceSkill(id, Integer.parseInt(skillDetMap.get("resourceskill1")),
				Integer.parseInt(skillDetMap.get("resourceskillrating1")),
				Boolean.parseBoolean(skillDetMap.get("resourceskillcore1"))
				);
		
		resourceService.updateResourceSkill(id, Integer.parseInt(skillDetMap.get("resourceskill2")),
				Integer.parseInt(skillDetMap.get("resourceskillrating2")),
				Boolean.parseBoolean(skillDetMap.get("resourceskillcore2"))
				);
		
		return "success";
	}
	
	/*@RequestMapping(value="/searchresource", method=RequestMethod.GET)
	public String returnResourceSearchForm(){
		
		return "searchresourceform";
	}
	
	@RequestMapping(value="/searchingresource", method=RequestMethod.POST)
	public ModelAndView searchingResource(@RequestParam("searchbynameorid") String searchCrit, 
			@RequestParam("searchvalue") String searchValue)
	{
		List<Resource> resources = new ArrayList<Resource>();
		if(searchCrit.equalsIgnoreCase("resourceid"))
			resources = resourceService.getResourcesById(Integer.parseInt(searchValue));
		else
			resources = resourceService.getResourcesByName(searchValue);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchresourceform");
		modelAndView.addObject("resources", resources);
		return modelAndView;
	}
	
	@RequestMapping(value="/editresource/{resourceid}" , method=RequestMethod.GET)
	public ModelAndView returnResourceEditForm(@PathVariable("resourceid") int resourceId){
		Resource resource =  resourceService.getResourceById(resourceId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("resource",resource);
		modelAndView.setViewName("editresourceform");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/editingresource" , method=RequestMethod.POST)
	public String editingResource(@ModelAttribute("resource") Resource resource){
		resourceService.updateResource(resource);
		return "success";		
	}
	
	@RequestMapping(value="/removeresource/{resourceid}" , method=RequestMethod.GET)
	public String removeResource(@PathVariable("resourceid") int resourceId){
		resourceService.removeResource(resourceId);
		return "success";
	}*/
	
	
	/**************************************************************************************************************/
	/*********************************Account Controller Handler methods*******************************************/
	//Account related handler mappings
	@RequestMapping(value="/accounts", method=RequestMethod.GET)
	public ModelAndView accountMaint(){
		
		List<Account> accounts =  accountService.listAccounts();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("accounts", accounts);
		modelAndView.setViewName("accounts");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/addaccount", method=RequestMethod.GET)
	public ModelAndView returnAccountForm(){
		List<Resource> managers =  resourceService.listResources();
		List<Businessunit> businessunits =  businessunitService.listBusinessunits();
		List<Deliveryunit> deliveryunits =  deliveryunitService.listDeliveryunits();		
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.addObject("managers", managers);
		modelAndView.addObject("businessunits", businessunits);
		modelAndView.addObject("deliveryunits", deliveryunits);
		modelAndView.setViewName("addaccountform");
		return modelAndView;
	}
	
	@RequestMapping(value="/addingaccount", method=RequestMethod.POST)
	public String addingAccount(@RequestParam("name") String name,
			@RequestParam("desc") String desc,
			@RequestParam("manager") int managerId,
			@RequestParam("businessunit") int buId,
			@RequestParam("deliveryunit") int duId,
			@RequestParam("startdate") String startDate,
			@RequestParam("enddate") String endDate,
			@RequestParam("domain") String domain,
			@RequestParam("subdomain") String subDomain,
			@RequestParam("ccp") String ccp,
			@RequestParam("status") String status,
			@RequestParam("type") String type
	
			){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Account account = new Account();
		account.setName(name);
		account.setDesc(desc);
		account.setManager(resourceService.getResourceById(managerId));
		account.setBusinessunit(businessunitService.getBusinessunitById(buId));
		account.setDeliveryunit(deliveryunitService.getDeliveryunitById(duId));
		account.setContactPerson(ccp);
		account.setStatus(status);
		account.setDomain(domain);
		account.setSubDomain(subDomain);
		account.setType(type);
		
		try {
			account.setStartDate(formatter.parse(startDate));
			account.setEndDate(formatter.parse(endDate));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		accountService.addAccount(account);
		
		return "success";
	}
	
	@RequestMapping(value="/searchaccount", method=RequestMethod.GET)
	public String returnAccountSearchForm(){
		
		return "searchaccountform";
	}
	
	@RequestMapping(value="/searchingaccount", method=RequestMethod.POST)
	public ModelAndView searchingAccount(@RequestParam("searchbynameorid") String searchCrit, 
			@RequestParam("searchvalue") String searchValue)
	{
		List<Account> accounts = new ArrayList<Account>();
		if(searchCrit.equalsIgnoreCase("accountid"))
			accounts = accountService.getAccountsById(Integer.parseInt(searchValue));
		else
			accounts = accountService.getAccountsByName(searchValue);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchaccountform");
		modelAndView.addObject("accounts", accounts);
		return modelAndView;
	}
	
	@RequestMapping(value="/editaccount/{accountid}" , method=RequestMethod.GET)
	public ModelAndView returnAccountEditForm(@PathVariable("accountid") int accountId){
		Account account =  accountService.getAccountById(accountId);
		List<Resource> managers = resourceService.listResources();
		List<Location> locations = locationService.listLocations();
		List<Businessunit> businessunits = businessunitService.listBusinessunits();
		List<Deliveryunit> deliveryunits = deliveryunitService.listDeliveryunits();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("account",account);
		modelAndView.addObject("managers",managers);
		modelAndView.addObject("locations", locations);
		modelAndView.addObject("businessunits", businessunits);
		modelAndView.addObject("deliveryunits", deliveryunits);
		modelAndView.setViewName("editaccountform");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/editingaccount/{id}" , method=RequestMethod.POST)
	public String editingAccount(@PathVariable("id") int id,
			@RequestParam("name") String name,
			@RequestParam("desc") String desc,
			@RequestParam("manager") int managerId,
			@RequestParam("businessunit") int buId,
			@RequestParam("deliveryunit") int duId,
			@RequestParam("startdate") String startDate,
			@RequestParam("enddate") String endDate,
			@RequestParam("domain") String domain,
			@RequestParam("subdomain") String subDomain,
			@RequestParam("ccp") String ccp,
			@RequestParam("status") String status,
			@RequestParam("type") String type){
		Account account = accountService.getAccountById(id);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		account.setName(name);
		account.setDesc(desc);
		account.setManager(resourceService.getResourceById(managerId));
		account.setBusinessunit(businessunitService.getBusinessunitById(buId));
		account.setDeliveryunit(deliveryunitService.getDeliveryunitById(duId));
		account.setContactPerson(ccp);
		account.setStatus(status);
		account.setDomain(domain);
		account.setSubDomain(subDomain);
		account.setType(type);
		
		try {
			account.setStartDate(formatter.parse(startDate));
			account.setEndDate(formatter.parse(endDate));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		accountService.updateAccount(account);
		return "success";		
	}
	
	@RequestMapping(value="/removeaccount/{accountid}" , method=RequestMethod.GET)
	public String removeAccount(@PathVariable("accountid") int accountId){
		accountService.removeAccount(accountId);
		return "success";
	}
	
	/**************************************************************************************************************/
	/*********************************ProjectManagementHome methods*******************************************/
	
	@RequestMapping(value="/projectmanagement/newresreq", method=RequestMethod.GET)
	public ModelAndView returnResRequestForm(HttpSession session){
		Resource resource = resourceService.getResourceById((int)session.getAttribute("resourceId")); 
		Account account = accountService.getAccountById(1);
		Project project = projectService.getProjectById(1);
		List<Skill> skills = skillService.listSkills();
		List<Location> locations = locationService.listLocations();
		ModelAndView modelAndView =  new ModelAndView();
		modelAndView.addObject("account", account);
		modelAndView.addObject("project", project);
		modelAndView.addObject("resource", resource);
		modelAndView.addObject("skills", skills);
		modelAndView.addObject("locations", locations);
		modelAndView.setViewName("newresrequestform");
		return modelAndView;
	}
	
	@RequestMapping(value="/projectmanagement/creatingresreq",method=RequestMethod.POST)
	public String creatingresreq(@RequestParam Map<String,String> resReqForm){
		
		manageResReqService.populateResReq(resReqForm);
		
		return null;
	}
	
	@RequestMapping(value="/projectmanagement/manageresreq",method=RequestMethod.GET)
	public String manageResRequest(){
		
		return "manageresrequest";
	}
	
	@RequestMapping(value="/projectmanagement/manageresreq/new",method=RequestMethod.POST)
	public void processNewResRequest(@RequestParam(value="reqDetIds") String[] reqDetIdArr){
		
		
		Integer[] reqDetIds= new Integer[reqDetIdArr.length];
		for(int i=0;i<reqDetIdArr.length;i++)
			reqDetIds[i]=Integer.parseInt(reqDetIdArr[i]);		
		
		manageResReqService.processNewResReq(reqDetIds);	
		
	}
	
	@RequestMapping(value="/projectmanagement/viewresreq", method=RequestMethod.GET)
	public String viewResRequest(){
		
		return null;
	}
	
	@RequestMapping(value="/projectmanagement/loadresreq",method=RequestMethod.POST)
	public @ResponseBody List<ResourceRequest> loadResRequests(){
		
		List<ResourceRequest> resourceRequests = new ArrayList<ResourceRequest>();
		Map resReqMap;
		for(Object object:manageResReqService.listResReq()){
			resReqMap = (Map)object;
			ResourceRequest resourceRequest = new ResourceRequest();
			
			resourceRequest.setRar_requestId((int)resReqMap.get("rar_id"));
			resourceRequest.setRar_project(projectService.getProjectById((int)resReqMap.get("rar_projectid")));
			resourceRequest.setRar_status((String)resReqMap.get("rar_status"));
			resourceRequest.setRar_owner(resourceService.getResourceById((int)resReqMap.get("rar_owner")));
			resourceRequest.setRar_billable((String)resReqMap.get("rar_billable"));
			
			
			resourceRequest.setRard_requestDetailId((int)resReqMap.get("rard_id"));
			resourceRequest.setRard_status((String)resReqMap.get("rard_status"));
			resourceRequest.setRard_primarySkill(skillService.getSkillById((int)resReqMap.get("rard_primaryskillid")));
			resourceRequest.setRard_secondarySkill(skillService.getSkillById((int)resReqMap.get("rard_secondaryskillid")));
			resourceRequest.setRard_domain(skillService.getSkillById((int)resReqMap.get("rard_domain")));
						
			if(resReqMap.get("rard_resproposedid") != null)
			resourceRequest.setRard_resProposed(resourceService.getResourceById((int)resReqMap.get("rard_resproposedid")));
			
			resourceRequest.setRard_decision((String)resReqMap.get("rard_decision"));
			resourceRequest.setRard_allcStartdate((Date)resReqMap.get("rard_startdate"));
			resourceRequest.setRard_allcEnddate((Date)resReqMap.get("rard_enddate"));
			resourceRequest.setRard_rmgApprover(resourceService.getResourceById((int)resReqMap.get("rard_rmgapprover")));
			resourceRequest.setRard_requestType((String)resReqMap.get("rard_requesttype"));
			resourceRequest.setRard_role((String)resReqMap.get("rard_rolerequired"));
			resourceRequest.setRard_allcType((String)resReqMap.get("rard_allctype"));
			resourceRequest.setRard_clientInterview((String)resReqMap.get("rard_clientinterview"));
			resourceRequest.setRard_competencyGroup((String)resReqMap.get("rard_competencygroup"));
			resourceRequest.setRard_location(locationService.getLocationById((int)resReqMap.get("rard_location")));
			
			
			resourceRequests.add(resourceRequest);
			
			
		}
		
		
			
		return resourceRequests;
		
		
		
	}
	

	/**************************************************************************************************************/
	/*********************************Ajax request methods*******************************************/
	
	@RequestMapping(value="/loadlocation", method=RequestMethod.POST)
	public @ResponseBody List<Location> loadLocation(){
		
		return locationService.listLocations();		
	}
	

}
