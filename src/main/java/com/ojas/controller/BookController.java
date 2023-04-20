package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ojas.configure.BookListPdf;
import com.ojas.configure.ExcelSheets;
import com.ojas.configure.Mail;
import com.ojas.entity.BookEntity;
import com.ojas.model.Book;
import com.ojas.service.BookServiceImpl;

@Controller
public class BookController {
	
	  @Autowired
      private BookServiceImpl serviceImpl ;
	
	
	@RequestMapping("/")
	public String add(Model model) {
		
		Book book = new Book();
		model.addAttribute("book",book);
		return "addBook";
	}
	
	
	@RequestMapping("/create")
	public String add(@ModelAttribute("book") Book book,Model model) {
		boolean flag = false;
	
		if(book != null) {
		flag =	serviceImpl.saveBook(book);
		}
	
		 if(flag) {
			 model.addAttribute("msg","Book is Added");
		 }else {
			 model.addAttribute("msg","Book is not Added");
		 }
		
		
		return "addBook";
	}
	
	@RequestMapping("/viewall")
	public String viewAll(Model model) {
		
		     List<Book> books = serviceImpl.findAllBooks();
		         if( books != null)
		         {
		        	 model.addAttribute("books", books);
		         }
		return "viewall";
	}
	
	@RequestMapping(value ="/editbook")
	public String editBook(@RequestParam("id") int id,Model model) {
		  Book book = serviceImpl.findBookById(id);
		  if(book != null) {
			  model.addAttribute("book", book);
		  }
		return "editBook";
	}
	
	
	@RequestMapping(value="/editbook", method=RequestMethod.POST)
	public String updateBook(@ModelAttribute("book") Book book,Model model) {
		 
	System.out.println(book.toString());
		
		boolean flag =false;
		  if(book != null) {
			 flag =serviceImpl.updateBook(book);
			 System.out.println("BOOK UPDATED");
		  }
		  
		  if(flag) {
			  model.addAttribute("msg", "Book is Updated");
		  }else {
			  model.addAttribute("msg", "Book is Not Updated");
		  }
		  
		return "redirect:/viewall";
	}
	
	@RequestMapping(value ="/deletebook" ,method=RequestMethod.GET)
	public String deleteBook(@RequestParam(value="id",required=false)  int id,Model model) {
		
		System.out.println("Id:"+id);
		  boolean flag = serviceImpl.deleteById(id);
		  if(flag) {
			  model.addAttribute("msg", "Book is deleted");
			  System.out.println("Book is deleted");
		  }else
		  {
			  model.addAttribute("msg", "Book is not deleted");
		  }
		return "redirect:/viewall";
	}
	@RequestMapping("/pdf")
	public String pdf(Model model) {
	List<Book> allBooks = serviceImpl.findAllBooks();
	String genetatePdf = BookListPdf.genetatePdf(allBooks);
	model.addAttribute("msg", genetatePdf);
		return "pdf";
		
	}
	@RequestMapping("/excel")
	public String excel(Model model) {
		List<Book> allBook = serviceImpl.findAllBooks();
		boolean excelReport = ExcelSheets.excelReport(allBook);
		if(excelReport) {
			model.addAttribute("msg", "Excel Sheet Generated");
		}
		else {
			model.addAttribute("msg", "Excel  Sheet Not Generated");
		}
		return "excel";
	}
	@RequestMapping("/email")
	public String email(Model model) {
		List<Book> allBooks = serviceImpl.findAllBooks();
		String genetatePdf = BookListPdf.genetatePdf(allBooks);
		String cc = "mallikabmd@gmail.com,pendyalajashwanth07@gmail.com,kalyansp12@gmail.com";
		boolean emailSend = Mail.emailSend("rajithachinnu14@gmail.com",cc, genetatePdf);
		if(emailSend) {
			model.addAttribute("msg", "Mail Generated");
		}
		else {
			model.addAttribute("msg", "Mail Not Generated");
		}
		return "email";
		
	}
	

}
