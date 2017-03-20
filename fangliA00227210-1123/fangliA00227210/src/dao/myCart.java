package dao;

import java.util.*;

import model.Book;

public class myCart {
	HashMap<String,Book> hm=new HashMap<String,Book>();
	
	public void addBook2(String id){
		if(hm.containsKey(id)){
			Book book=hm.get(id);
			int shoppingNum=book.getShoppingnums();
			book.setShoppingnums(shoppingNum+1);
		}else{
			Book books=ProductDAO.instance.get((Integer.parseInt(id)));
			hm.put(id, books);
		}
	}

public void addBook(String id,Book book){
	if(hm.containsKey(id)){
		book=hm.get(id);
		int shoppingnum=book.getShoppingnums();
		book.setShoppingnums(shoppingnum+1);
		//hm.put(id, book);
	}else{
	hm.put(id, book);}
}
public void delBook(String id){
	hm.remove(id);
}
public void updateBook(String id,String nums){
	Book book=hm.get(id);
	int num=(Integer.parseInt(nums));
	book.setShoppingnums(num);
	
}
public ArrayList showMyCart(){
	ArrayList<Book> al=new ArrayList<Book>();
	Iterator iterator=hm.keySet().iterator();
	while(iterator.hasNext()){
		String id=(String)iterator.next();
		Book book=hm.get(id);
		al.add(book);
	}
	return al;
}
public void clearBook(){
	hm.clear();
}

public float getTotalPrice(){
	float totalPrice=0.0f;
	ArrayList<Book> al=new ArrayList<Book>();
	Iterator iterator=hm.keySet().iterator();
	while(iterator.hasNext()){
		String bookid=(String) iterator.next();
		Book book=hm.get(bookid);
		totalPrice+=book.getPrice()*book.getShoppingnums();
	}
	return totalPrice;
}
}

