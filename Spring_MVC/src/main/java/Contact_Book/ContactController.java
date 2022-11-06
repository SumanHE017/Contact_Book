package Contact_Book;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

	@Autowired
	MyContactsDao dao;
	@RequestMapping("/addcontact")
	public ModelAndView addContact() {
		ModelAndView mav=new ModelAndView("addcontact.jsp");
				MyContacts mc=new MyContacts();
		mav.addObject("contact",mc);
		return mav;
		
	}
	@RequestMapping("/savecontact")
	public ModelAndView savecontact(@ModelAttribute MyContacts mc) {
		ModelAndView mav=new ModelAndView("menu,jsp");
		dao.saveContact(mc);
		return mav;
		
	}
	@RequestMapping("/viewall")
	public ModelAndView getAllContacts() 
	{
		ModelAndView mav=new ModelAndView("viewall.jsp");
		List<MyContacts> c=dao.getAllContacts();
        mav.addObject("contacts",c);
        return mav;
}
	@RequestMapping("/update")
	public ModelAndView update (@RequestParam int id) {
		ModelAndView mav=new ModelAndView("update.jsp");
		MyContacts mc=dao.getcontactsById(id);
		mav.addObject("contact", mc);
		return mav;
	}
	
	@RequestMapping("/updateContact")
	public ModelAndView updateContact(@ModelAttribute MyContacts mc) {
		ModelAndView mav=new ModelAndView("menu.jsp");
		dao.updateContact(mc);
		return mav;
	}
	@RequestMapping("/delete")
	public ModelAndView delete (@RequestParam int id) {
		ModelAndView mav=new ModelAndView("menu.jsp");
		MyContacts mc=dao.getcontactsById(id);
		 dao.deleteContact(id);
	mav.addObject("contact",mc);
	return mav;
	}
	@RequestMapping("/deleteContact")
	public ModelAndView deleteContact() {
		ModelAndView mav=new ModelAndView("delete.jsp");
		List<MyContacts>c=dao.getAllContacts();
		mav.addObject("contacts",c);
		return mav;
	}
	 
}
 