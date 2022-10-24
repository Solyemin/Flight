package com.divyanshu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PrepareResultDikhstras {
	public ArrayList<Flight> solve(ArrayList<Flight> flightList, String sourceCity, String destinationCity) {
		if(flightList==null || sourceCity.toLowerCase().equals(destinationCity.toLowerCase()))return null;
		
		ArrayList<Flight> resultList = new ArrayList<>();
		sourceCity = sourceCity.toLowerCase().trim();
		destinationCity = destinationCity.toLowerCase().trim();

		int E = flightList.size();// this is the number of edges in the graph

		HashSet<String> st = new HashSet<>();
		// create the hashmap to store the cities

		HashMap<String, Integer> CityToNodeMap = new HashMap<>();
		HashMap<Integer, String> NodeToCityMap = new HashMap<>();
		HashMap<String, Flight> JourneyToFlightMap2 = new HashMap<>();


		// preparing the cost mapping with only those flights having only the minimum
		// cost between citya and cityb
		for (int i = 0; i < E; i++) {

			Flight f = flightList.get(i);// get the flight details

			String citya, cityb;
			// citya = reader.readLine();
			citya = f.getSourceCity().toLowerCase();
			// cityb = reader.readLine();
			cityb = f.getDestinationCity().toLowerCase();

			st.add(citya);
			st.add(cityb);

			int cost = (int) f.getCost();// get the fare of the flight

			Pair p = new Pair(citya, cityb);// make a pair of the (<citya,cityb> , fare ) type

			String key = citya + "#" + cityb;
			
			if (!JourneyToFlightMap2.containsKey(key)) {
				JourneyToFlightMap2.put(key, new Flight(f));
				System.out.println("NOT PRESENT--------");
				System.out.println("Put the value of (" + p.getA() + " " + p.getB() + ")" + ":"
						+ JourneyToFlightMap2.get(key).getFlightId());
			}

			else if (JourneyToFlightMap2.containsKey(key) && JourneyToFlightMap2.get(key).getCost() > cost) {
				JourneyToFlightMap2.put(key, new Flight(f));
				System.out.println("Modifying ::");
				System.out.println("Put the value of (" + p.getA() + " " + p.getB() + ")" + ":"
						+ JourneyToFlightMap2.get(key).getFlightId());
			}

		}

		
		System.out.println("Testing hashmap");
		for (Map.Entry<String, Flight> entry : JourneyToFlightMap2.entrySet()) {

			String key = entry.getKey();
			String cities[] = key.split("#");
			System.out.println("(" + cities[0] + "," + cities[1] + ")");
			Flight f = entry.getValue();
			System.out.println("Flight Details:");
			System.out.println(f.getFlightId());
			System.out.println(f.getSourceCity());
			System.out.println(f.getDestinationCity());
			System.out.println(f.getCost());
			// System.out.println(f.getCompanyName());

		}
		System.out.println("Testing hashmap");
		// now each city has been numbered as 0,1,2.... to identify it in the graph
		int count = 0;
		for (String str : st) {
			System.out.println("Current city:" + str);
			CityToNodeMap.put(str, count);
			NodeToCityMap.put(count, str);
			count++;
		}
		//check if either the source or the destination doesn't exist in the flightlist return null
		if(!CityToNodeMap.containsKey(sourceCity) || !CityToNodeMap.containsKey(destinationCity))return null;

		int V = st.size();

		ArrayList<ArrayList<Dikshtras.AdjListNode>> graph = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		
		int source = CityToNodeMap.get(sourceCity);// get the source index
		System.out.println("Source city index is " + source);

		
		for (Map.Entry<String, Flight> entry : JourneyToFlightMap2.entrySet()) {
			int a, b, w;

			Flight f = entry.getValue();
			// Pair p = entry.getKey();
			String cities[] = entry.getKey().split("#");
			a = CityToNodeMap.get(cities[0]);
			b = CityToNodeMap.get(cities[1]);
			w = (int) f.getCost();
			graph.get(a).add(new Dikshtras.AdjListNode(b, w));
		}

		int[] parent = new int[V + 1];
		for (int i = 0; i < V; i++)
			parent[i] = -1;
		// getting the minimum fare for each city from the source city
		int[] distance = Dikshtras.dijkstra(V, graph, source, parent);
		// Printing the Output
		
        //check the parent of the destination city , if -1 then no path return null
		if(parent[CityToNodeMap.get(destinationCity)]==-1)return null;
		
		System.out.println("Vertex "
				+ " Distance from Source");
		for (int i = 0; i < V; i++) {
			System.out.println(NodeToCityMap.get(i) + " "
					+ distance[i]);
		}

		int dest = CityToNodeMap.get(destinationCity);
		int current = dest;
		System.out.println("The minm distance from " + source + "to" + dest + " is " + distance[dest]);

		ArrayList<String> pathFromDestToSource = new ArrayList<>();
		while (current != -1) {
			// System.out.print(mp3.get(current) + " ");
			String city = NodeToCityMap.get(current);
			System.out.println("City:" + city);
			pathFromDestToSource.add(new String(NodeToCityMap.get(current)));// store the city for the given node
			current = parent[current];
		}
		for (int i = pathFromDestToSource.size() - 1; i > 0; i--) {
			String srcCity, destCity;
			srcCity = pathFromDestToSource.get(i);
			System.out.println("Source" + srcCity);
			destCity = pathFromDestToSource.get(i - 1);
			System.out.println("Dest" + destCity);
			System.out.println("this is working fine \n");
			Pair p = new Pair(srcCity, destCity);
			String key = p.getA() + "#" + p.getB();

			Flight f3 = JourneyToFlightMap2.get(key);
			if (!JourneyToFlightMap2.containsKey(key))
				System.out.println("Null value !");
			if (JourneyToFlightMap2.containsKey(key))
				System.out.println("Okay this time");
			if (JourneyToFlightMap2.get(key) != null) {
				System.out.println("Not Null here ");
				// Flight f3 = new Flight(JourneyToFlightMap.get(p));
			}

			System.out.println("id here" + f3.getFlightId());
			resultList.add(new Flight(JourneyToFlightMap2.get(key)));

			System.out.println("HELLO from the other side-- ");
		}

		return resultList;

	}
}
