//02-05-2018
Map p = Collections.synchronizeMap(hashMap);

import java.util*;

public class TestMap{
	public static void main(String[] args) {
		HashMap<String, Integer> scores = new HashMap<>();

		scores.put("Katyh", 42);
		scores.put("Bert", 434);
		scores.put("Skyler", 420);

		System.out.println(socres);
		System.out.println(socres.get("Bert"));
	}
}

class Multi extends Thread{
	public void run(){
		System.out.print("thread is running...");
	}
public static void main(String[] args){
	Multi t1 = new Multi();
	t1.start();
}
}

class Multi3 implements Runnable{
	public void run(){
		System.out.println("thread is running...");
	}
	public static void main(String[] args){
		Multi3 m1 = new Multi3();
		Thread t1 = new Thread(m1);
		t1.start();
	}
}

public class Worker extends Thread{
	public void run(){
		//Loop for ten iterations
		for(int i = 0; i < 10; i++){
			System.out.println(i + " looping ...");
			//sleep for a while
			try{
				Thread.sleep(200);
			}catch (InterruptedException e){
				break;
			}
		}
	}
}
public class Application{
	Worker worker1 = new Worker();
	worker1.start();

	Worker worker2 = new Worker();
	worker2.start();
}

class CodeRunner implements Runnable{
	public void run(){
		for(int i = 0; i < 10; i++){
			System.out.println(i + "looping...");

			try{
				thread.sleep(200);
			} catch(InterruptedException e){
				break;
			}
		}
	}
}
public class Application {
	public static void main(String[] args){
		CodeRunner runner = new CodeRunner();
		Tread thread = new Thread(runner);
		thread.start();
	}
}

public class MessageUtil{
	private String message;

	public MessageUtil(String message){
		this.message = message;
	}
	public String printMessage(){
		System.out.println(message);
		return message;
	}
}

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit{
	String message = "Hello World";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test
	public void testPrintMessage(){
		assertEquals(message, messageUtil.printMessage());
	}
}
public class TestRunner{
	public static void main(String[] args){
		Result result = JUnitCore.runClasses(TestJunit.class);

		for(Failure failur: result.getFailures()){
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}
}

public abstract class Employee{
	privat String name;
	private String address;
	private int number;

	public Employee(String name, String address, int number){
		System.out.println("Constructing an Employee");
		this.name = name;
		this.address = address;
		this.number = number;
	}

	public double computePay(){
		System.out.println("Inside Employee computePay");
		return 0.0;
	}
}

public class AbstractDemo{
	public static void main(String[] args){

	}
}

public class Salary extends Employee{
	private double salary;
}

public abstract class Employee{
	private String name;
	private String address;
	private int number;
	public abstract double computePay();
}
public class Salary extends Employee{
	private double salary;

	public double computePay(){
		System.out.println("Computing salary pay for" + getNam());
		return salary/52;
	}
}

abstract class Shape{
	String color;
	abstract double area();
	public abstract String toString();

	public Shape(String color){
		System.out.println("Shape constructor called");
		this.color = color;
	}
	public String getColor(){
		return color;
	}
}

class Circle extends Shape{
	double radius;
	public Circle(String color, double radius){
		super(color);
		System.out.println("Circle constructor called");
		this.radius = radius;
	}

	@override
	double area(){
		return Math.PI * Math.pow(radius, 2);
	}
}

class Rectangle extends Shape{
	double length;
	double width;
	public Rectangle (String color, double length, double width){
		super(color);
		this.length = legth;
		this.width = width;
	}
	@override
	double area(){
		return length * width;
	}
}
public class Test{
	public static void main(String[] args){
		Shape s1 = new Circle("Red", 2.2);
		Shape s2 = new Rectangle("Yellow", 2, 4);
	}
}

public class Encapsulate{
	private String name;
	private int age;

	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public void setName(String newName){
		name = newName;
	}
	public void setAge(int newAge){
		age = newAge;
	}
}
public class TestEncapsulation{
	public static void main(Stringp[] args){
		Encapsulate obj = new Encapsulate();
		obj.setName("Harsh");
		obj.setAge(19);
		System.out.println("Name:" + obj.getName());
	}
}
import java.io.*;
interface in1{
	final int a = 10;
	void display();
}
class testClass implements in1{
	public void display(){
		System.out.println("Geek");
	}
	public static void main(Stringp[] args){
		testClass t= new testClass();
		t.display();
		System.out.println(a);
	}
}

import java.io.*;
interface Vehicle{
	void changeGear(int a);
	void speedUp(int a);
	void applyBrake(int a);
}

class Bicycle implements Vehicle{
	int speed;
	int gear;
	@override
	public void ChangeGear(int newGear){
		gear = newGear;
	}
	@override
	public void speedUp(int increment){
		speed += increment;
	}
	@override
	public void applyBrake(int decrement){
		speed -= decrement;
	}
	public void printState(){
		System.out.println("speed: " + speed + "gear: " + gear);
	}
}
class CFG{
	public static void main(String[] args){
		Bicycle bicycle = new Bicycle();
		bicycle.changeGear(2);
		bicycle.speedUp(3);
		bicycle.applyBrake(1);
		bicycle.printState();
	}
}

class Test{
	int a;
	int b;

	Test(int a, int b){
		this.a = a;
		this.b = b;
	}

	void display(){
		System.out.println(a + b);
	}

	public static void main(String[] args){
		Test object = new Test(10, 20);
		object.display();
	}
}

class Test{
	int a;
	int b;

	Test(){
		a = 10;
		b = 20;
	}

	Test get(){
		return this;
	}

	public static void main(String[] args){
		Test object = new Test();
		object.get.display();
	}
}

class Vehicle{
	int maxSpeed = 120;
}

class Car extends Vehicle{
	int maxSpeed = 180;
	void display(){
		System.out.println("Maximum Speed: " + super.maxSpeed);
	}
}
class Test{
	public static void main(String[] args) {
		Car small = new Car();
		small.display();
	}
}

class Test{
	static void m1(){
		System.out.println("from m1");
	}
	public static void main(String[] args) {
		m1();
	}
}

class Test{
	static int a = 10;
	int b = 20;

	static void m1(){
		System.out.println("from m1");
	}
}
class Student{
	String name;
	int rollNo;

	static int counter = 0;
	public Student(String name){
		this.name = name;
		this.rollNo = setRollNo();
	}

	static int setRollNo(){
		counter++;
		return counter;
	}
}

class CFG{
	public static void main(String[] args) {
		int[] arr = new int[4];
		try{
			int i = arr[4];
			System.out.println("Inside try block"):
		} catch(ArrayIndexOutOfBoundsException ex){
			Sytem.out.println("Exception caught");
		}
		System.out.println("Outside try-catch clause");
	}
}

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class K{
	private static final int SIZE = 10;
	public static void main(String[] args) {
		PrintWriter out = null;
		try{
			system.out.println("Entered try statement");
			out = new PrintWriter(new FileWriter("OutFile.txt"));
		}catch(IOException e){

		}
		finally{
			if(out != null){
				System.out.println("Closing PrintWriter");
				out.close();
			}
			else{
				System.out.println("PrintWriter not open"):
			}
		}
	}
}
protected void finalize throws Throwable{}

public class Cat{
	String name;
	int age;
	public Cat(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String display(){
		return ("Hi my name is " + this.getName() + ".\nadnd my age is  " + this.getAge();
	}
	public static void main(String[] args) {
		Cat cat = new Cat("Kally", 20);
		System.out.println(cat.display());
	}
}

class Car{
	int no;
	Car(int no){
		this.no = no;
	}
}
class Main{
	public static void swap(Car c1, Car c2){
		int temp = c1.no;
		c1.no = c2.no;
		c2.no = temp;
	}
	public static void main(String[] args) {
		Car c1 = new Car(1);
		Car c2 = new Car(2);
		swap(c1, c2);
		System.out.println()
	}
}

File a = new File("/usr/local/bin/geeks");

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

class Contents{
	public static void main(String[] args) {
		BufferReader br = new BufferReader(new InputStreamReader(System.in));

		System.out.println("Enter dirpath:");
		String dirpath = br.readline();
		System.out.println("Enter the dirname");
		String dname = br.readlin();

		File f = new File(dirpath, dirname);

		if(f.exists()){
			String arr[] = f.list();
			int n = arr.length;
			for(int i = 0; i < n; i++){
				System.out.println(arr[i]);
				File f1 = new Filw(arr[i]);
				if(f1.isFile()){
					System.
				}
			}
		}
	}
}

BufferReader in = new BufferReader(Reader in, int size);
File file = new File("");
BufferReader br = new BufferReader(new FileReader(file));
String st;
while((st = br.readlin() != null))

import java.io.File;
import java.util.Scanner;
public class ReaderFromFileUsingScanner{
	public static void main(String[] args) {
		File file = new File("directory");
		Scanner sc = new Scanner(file);
	}
	while(sc.hasNextLine()){
		System.out.println(sc.nextLine());
	}
}
public void Write() throws IOException{
	String str = "Hello";
	BufferWriter writer = new BufferWriter(new FileWrite(fileName));
	writer.write(str);
	writer.close();
}

import java.io.File;
public fileHandling() throws IOException{
	public static void main(String[] args) {
		try{
			File input = new File("input");
		File output = new File("output");
		Scanner sc = new Scanner(input);
		PrintWriter printer = new PrintWriter(output);
		while(sc.hasNextLine()){
			String s = sc.nextLin();
			printer.write(s);
			}
		} catch(FileNotFoundException e){
			System.err.println("File not found.");
		}
	}
}

//02-07-2018

public class solution{
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> list = new ArrayList<>();
		if(root == null){
			return list;
		}
		List<Integer> left = preorderTraversal(root.left);
		List<Integer> right = preorderTraversal(root.right);

		list.add(root);
		list.addAll(left);
		list.addAll(right);

		return list;
	}
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
		if(root == null){
			return list;
		}
		stack.push(root);
		Stack<TreeNode> stack = new Stack<>();
		while(!stack.empty()){
			TreeNode node = stack.pop();
			list.add(node.val);
			if(node.right != null){
				stack.push(node.right);
			}
			if(node.left != null){
				stack.push(node.left);
			}
		}
		return list;
	}
}

//02-08-2018
public class solution{
	public int[] twoSume(int[] nums, int target){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i ++){
			if(map.get(nums[i]) != null){
				int[] result = {map.get(nums[i]), i};
				return result;
			}
			map.put(target - nums[i], i);
		}
		int[] result = {};
		return result;
	}
}

public class solution{
	public ListNode reverse(ListNode head){
		ListNode pre = null;
		while(head != null){
			ListNode tmp = head.next;
			head.next = pre;
			pre = head;
			head = tmp;
		}
		return pre;
	}
}

//02-14-2018
public class Solution{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null){
			return l2;
		}
		else if(l2 == null){
			return l1;
		}
		else if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
		else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
public class Solution{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode prehead = null;
		ListNode prev = prehead;

		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				prev.next = l1;
				prev = l1;
				l1 = l1.next;
			}
			else{
				prev.next = l2;
				prev = l2;
				l2 = l2.next;
			}
		}
		if(l1 == null){
			prev.next = l2;
		}
		if(l2 == null){
			prev.next = l1;
		}
		return prehead.next;
	}
}
ArrayList<T> al = new ArralyList<>();
Vector<T> v = new Vector<T>();
Enumeration e = v.elements();
public boolean hasMoreElements();
public Object nextElement();

import java.util.Enumeration;
import java.util.Vector;

public class Test{
	public static void main(String[] args) {
		Vector v = new Vector();
		for(int i = 0; i < 10; i++){
			v.addElement(i);
		}
		System.out.println(v);
		Enumeration e = v.elements();
		while(e.hasMoreElements()){
			int i = (Integer)e.nextElement();
			System.out.print(i + " ");
		}
	}
}
Iterator itr = c.iterator();

import java.util.ArrayList;
import java.util.Iterator;

public class Test{
	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		for(int i = 0; i < 10; i++){
			a1.add(i);
		}
		System.out.println(a1);
		Iterator itr = a1.iterator();
		while(itr.hasNext()){
			int i = (Integer)itr.next();
			System.out.print(i + " ");
			if(i % 2 != 0){
				itr.remove();
			}
		}
		System.out.println();
	}
}
import java.io.*;
import java.util.*;

class GFG{
	public static void main(String[] args) {
		ArrayList<String> a1 = new ArrayList<>();

		a1.add("Practice");
		a1.add("Quiz");
		a1.add("code");
		a1.add("contribute");

		Iterator it = a1.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

		Vector<String> v = new Vector<>();
		v.addElement("Practice");
		v.addElement("quiz");
		v.addElement("code");

		Enumeration e = v.elements();
		while(e.hasMoreElements()){
			System.out.println(e.nextElements());
		}
	}
}
//02-16-2018
class Solution{
	public TreeNode deleteAllNodesLess(TreeNode root){
		
	}
}








