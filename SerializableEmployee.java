
import java.io.*;
import java.util.*;

public class SerializableEmployee {
	static ArrayList<Employee> al = null;
	static ObjectOutputStream out = null;
	static ObjectInputStream in = null;
	static int count=0;

	public SerializableEmployee() throws FileNotFoundException, IOException {
		out = new ObjectOutputStream(new FileOutputStream("Records.bin"));
		in = new ObjectInputStream(new FileInputStream("Records.bin"));
	}

	public static void add(int id, String name, String designation,int salary) {
		try {
			get();
			if (al == null)
				al = new ArrayList<Employee>();
			al.add(new Employee(id, name, designation, salary));
			count++;
			put();
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	public static Object [][] showRecords() {
		Object [][] res=null;
		try {
			get();
			if (al == null) {
				System.out.println("File is Empty!");
			} else {
				res = new Object[count][4];
				int r=0;
				ListIterator<Employee> i = al.listIterator();
				while (i.hasNext()) {
					Employee temp = (Employee) i.next();
					res[r][0] = temp.getId();
					res[r][1] = temp.getName();
					res[r][2] = temp.getDesignation();
					res[r][3] = temp.getSalary();
					r++;
				}
			}
		} catch (Exception e) {
		}
		return res;
	}

	public static boolean modify(int id,String name,String designation,int salary,Object obj,int field) {
		boolean res = false;
		try {
			get();
			if(al==null)
				System.out.println("File is Empty!");
			else {
				ListIterator<Employee> i = al.listIterator();
				while(i.hasNext()) {
					Employee temp = (Employee)i.next();
					switch(field) {
					case 1:	if(id==temp.getId()) {
								int newId = (int)obj;
								Employee e = new Employee(newId,temp.getName(),temp.getDesignation(),temp.getSalary());
								i.remove();
								al.add(e);
								res = true;
							}
							break;
					case 2: if(name.equals(temp.getName())) {
								String newName =(String)obj;
								Employee e = new Employee(temp.getId(),newName,temp.getDesignation(),temp.getSalary());
								i.remove();
								al.add(e);
								res = true;
							}
							break;
					case 3: if(designation.equals(temp.getDesignation())) {
								String newDesignation= (String)obj;
								Employee e = new Employee(temp.getId(),temp.getName(),newDesignation,temp.getSalary());
								i.remove();
								al.add(e);
								res = true;
							}
							break;
					case 4: if(salary==temp.getSalary()) {
								int newSalary = (int)obj;
								Employee e = new Employee(temp.getId(),temp.getName(),temp.getDesignation(),newSalary);
								i.remove();
								al.add(e);
								res = true;
							}
							break;
					}
				}
			}
			put();
		}catch(Exception e){
			
		}
		return res;
	}

	public static boolean delete(int id,String name,String designation,int salary, int field) {
		boolean res = false;
		try {
			get();
			if(al==null)
				System.out.println("File is Empty!");
			else {
				ListIterator<Employee> i = al.listIterator();
				while(i.hasNext()) {
					Employee temp = (Employee)i.next();
					switch(field) {
					case 1:	if(id==temp.getId()) {
								i.remove();
								res = true;
								count--;
							}
							break;
					case 2: if(name.equals(temp.getName())) {
								i.remove();
								res = true;
								count--;
							}
							break;
					case 3: if(designation.equals(temp.getDesignation())) {
								i.remove();
								res = true;
								count--;
							}
							break;
					case 4: if(salary==temp.getSalary()) {
								i.remove();
								res = true;
								count--;
							}
							break;
					}
				}
			}
			put();
		}catch(Exception e){
			
		}
		return res;
	}

	public static void get() {
		try {
			Object obj;
			while((obj=in.readObject())!=null) {
				al = (ArrayList<Employee>)obj;
			}
		}catch(EOFException e) {
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void put() {
		try {
			out.writeObject(al);
			al=null;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
