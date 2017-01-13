package com.daniel.resource.database;

import java.util.ArrayList;
import java.util.Map;

import com.daniel.resource.bundle.*;



//------------------------------------------------------------------------
// Detta är endast för testning, endast en användare kan använda "databasen"
//
// Om SQL används så ersätts metoderna med sql queries.
//------------------------------------------------------------------------

public class RouteService {
	
	private static Map<Integer, Route> routes = DatabaseForTesting.getRoutes();
	

	public RouteService(){
		
		//------------------------------------------------------------------------
		// lägger till routs för testning
		//------------------------------------------------------------------------
		
		ArrayList<Place> arrayListPlace1 = new ArrayList<Place>();
		ArrayList<LatLng> arrayListPoss1 = new ArrayList<LatLng>();
		
		ArrayList<Place> arrayListPlace2 = new ArrayList<Place>();
		ArrayList<LatLng> arrayListPoss2 = new ArrayList<LatLng>();
		
		
		arrayListPlace1.add(new Place( 1, new LatLng(63.700083, 20.371056), "Sten" , "stor sten"));
		arrayListPlace1.add(new Place( 1, new LatLng(63.68228, 20.415344), "Bro" ,  "fin bro"));
		
		arrayListPoss1.add(new LatLng(63.689661, 20.424271));
		arrayListPoss1.add(new LatLng(63.718483, 20.458431));
		arrayListPoss1.add(new LatLng(63.730262, 20.387192));
		arrayListPoss1.add(new LatLng(63.710957, 20.343761));
		arrayListPoss1.add(new LatLng(63.685629, 20.336037));
		
		String test1 = "Midvinternattens köld är hård, "
				+ "stjärnorna gnistra och glimma."
				+ "Alla sova i enslig gård"
				+ "djupt under midnattstimma."
				+ "Månen vandrar sin tysta ban,"
				+ "snön lyser vit på fur och gran,"
				+ "snön lyser vit på taken."
				+ "Endast tomten är vaken.";
		
		Route path1 = new Route(1, arrayListPlace1, arrayListPoss1, "Skogstur1", test1, "10.8 km", "2.4 timmar");
		
		
		arrayListPlace2.add(new Place( 2, new LatLng(55.5464, 20.000), "Sten" , "stor sten"));
		arrayListPlace2.add(new Place( 2, new LatLng(55.5324, 20.010), "Bro" ,  "fin bro"));
		
		arrayListPoss2.add(new LatLng(55.5464, 20.010));
		arrayListPoss2.add(new LatLng(55.5464, 20.020));
		arrayListPoss2.add(new LatLng(55.5464, 20.030));
		arrayListPoss2.add(new LatLng(55.5464, 20.040));
		arrayListPoss2.add(new LatLng(55.5464, 20.050));

		Route path2 = new Route(2, arrayListPlace2, arrayListPoss2, "Skogstur2", "fin tur", "10.8 km", "2.4 timmar");
		
		routes.put(path1.getId(),path1);
		routes.put(path2.getId(),path2);
		
		

	}
	
	
	
	public ArrayList<InfoRoute> getInfoAllRouts(){
		ArrayList<Route> arrayListRoute = new ArrayList<Route>(routes.values());
		ArrayList<InfoRoute> arrayListInfoRoute = new ArrayList<InfoRoute>();
		
		for(int i=0; i<arrayListRoute.size();i++){
			arrayListInfoRoute.add(new InfoRoute(arrayListRoute.get(i).getId(),arrayListRoute.get(i).getName(), arrayListRoute.get(i).getLength(), arrayListRoute.get(i).getDuration(), arrayListRoute.get(i).getInfo()));
		}
		
		return arrayListInfoRoute;
	}
	
	public Route getSpecificRouteData(int id){
		return routes.get(id);
	}
	
	public Route addRoute(Route routeTemp){
		ArrayList<Route> arrayListRoute = new ArrayList<Route>(routes.values());
		int temp=0;
		if(arrayListRoute.size()!=0){
			temp=arrayListRoute.get(0).getId();
			for(int i=1; i<arrayListRoute.size();i++){
				if(temp<=arrayListRoute.get(i).getId()){
					temp++;
				}
			}				
		};
	
		temp++;
		routeTemp.setId(temp);	
		for(int i=0; i<routeTemp.getPlaces().size();i++){
			routeTemp.getPlaces().get(i).setRouteId(temp);
		}
		
		
		routes.put(temp, routeTemp);
		return routeTemp;
	}
	
	public Route updateRoute(Route routeTemp){
		ArrayList<Route> arrayListRoute = new ArrayList<Route>(routes.values());
		boolean temp=false;
		for(int i=0; i<arrayListRoute.size();i++){
			if(arrayListRoute.get(i).getId() == routeTemp.getId()){
				temp=true;
				System.out.println( "4" ) ;
			}
		}
		
		if(temp){
			System.out.println( "3" ) ;
			for(int i=0; i<routeTemp.getPlaces().size();i++){
				routeTemp.getPlaces().get(i).setRouteId(routeTemp.getId());
				System.out.println( "2" ) ;
			}
			routes.put(routeTemp.getId(), routeTemp);
			return routeTemp;
		}else{
			System.out.println( "1" ) ;
			routeTemp.setId(-1);
			return routeTemp;
		}
	
	}
	
	public void deleteRoute(int id){
		ArrayList<Route> arrayListRoute = new ArrayList<Route>(routes.values());
		boolean temp=false;
		for(int i=0; i<arrayListRoute.size();i++){
			if(arrayListRoute.get(i).getId() == id){
				temp=true;
				System.out.println( "4Hello, World!" ) ;
			}
		}
		System.out.println( "3Hello, World!" ) ;
		if(temp){
			System.out.println( "2Hello, World!" + Integer.toString(id) ) ;
			routes.remove(id);			
		}
	
	}

}