package io.learning.bookshop;

//import io.learning.bookshop.books.BooksRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import java.time.LocalDate;

@SpringBootApplication
public class BookshopApplication  {
//	@Autowired BooksRepository booksRepository;

	public static void main(String[] args) {SpringApplication.run(BookshopApplication.class, args);}


}

//	@Override
//	public void run(String... args) throws Exception
//	{
//		Books books = new Books("Lol","Nope","$4.20","3");
//		booksRepository.save(books);
//
//		Employees employees = new Employees("Horse","3NopeBlvd","N/A","SanDiego","CA","2014881138", LocalDate.now(),"$65000","T");
//		employeesRepository.save(employees);
//
//		Members members = new Members("Joe","1LolRd","Apt2","Wackensack","NJ","2017543445", LocalDate.now(), LocalDate.of(2023,4,23),"Yes");
//		membersRepository.save(members);
//
//		Purchases purchases = new Purchases(2, LocalDate.of(2000,1,1),LocalDate.of(2000,1,2),
//				'F',1,books,members);
//		purchasesRepository.save(purchases);
//
//		Sales sales = new Sales(2, 5000, LocalDate.now(),books,members);
//		salesRepository.save(sales);
//
//		Suppliers suppliers = new Suppliers("Steve","2016881132","5YourBagelSt","Unit3","LasVegas","NV");
//		suppliersRepository.save(suppliers);
//	}
//}
