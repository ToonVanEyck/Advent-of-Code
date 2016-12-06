import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class Day3 {

	public static void main(String[] args) throws IOException {
		String inputFile="input3.txt";
		ArrayList<Triangle> triangles =new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String line1,line2,line3;
			/*
		    while ((line1 = br.readLine()) != null) {
		    	List<String> s = new ArrayList<String>(Arrays.asList(line1.trim().split("\\W+")));
		    	triangles.add(new Triangle(Integer.parseInt(s.get(0)),Integer.parseInt(s.get(1)),Integer.parseInt(s.get(2))));
		    }
			*/
		    while ((line1 = br.readLine())!= null &&(line2 = br.readLine())!= null &&(line3 = br.readLine())!= null) {
		    	List<String> s = new ArrayList<String>(Arrays.asList(line1.trim().split("\\W+")));
    			s.addAll(new ArrayList<String>(Arrays.asList(line2.trim().split("\\W+"))));
    			s.addAll(new ArrayList<String>(Arrays.asList(line3.trim().split("\\W+"))));
    			System.out.println(s.toString());
		    	triangles.add(new Triangle(Integer.parseInt(s.get(0)),Integer.parseInt(s.get(3)),Integer.parseInt(s.get(6))));
		    	triangles.add(new Triangle(Integer.parseInt(s.get(1)),Integer.parseInt(s.get(4)),Integer.parseInt(s.get(7))));
		    	triangles.add(new Triangle(Integer.parseInt(s.get(2)),Integer.parseInt(s.get(5)),Integer.parseInt(s.get(8))));
		    }
		}		
		
		
		
		
		
		int count=0;
		for(Triangle t:triangles)
		{
			System.out.println(t);
			if(t.isLegit())count++;
		}
		System.out.println(triangles.size());
		System.out.println(count);
	}

}
