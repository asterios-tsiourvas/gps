import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;



public class Main {

    public static void main(String[] args) throws IOException {
    	
    	CSV_Reader MyReader= new CSV_Reader();
        ArrayList<Point> points = MyReader.readPoints("C://Users//TURBO_X//Desktop//nodes.csv");
        ArrayList<Taxi> taxis = MyReader.readTaxis("C://Users//TURBO_X//Desktop//taxis.csv");
        Client client = MyReader.readClient("C://Users//TURBO_X//Desktop//client.csv");
        HashMap<Point, ArrayList<Point>> neighbors = MyReader.GetNeighbors();
      
        Point p;
        ArrayList<Point> resolved_taxis = new ArrayList<>();
        for (Taxi t: taxis ) {
            p = t.resolveTaxi(points);
            resolved_taxis.add(p);
        }// ok
        Point resolved_client;
        resolved_client = client.resolveTaxi(points);
        //ok
        
        AStar MyAstar = new AStar();
        for (Point point: resolved_taxis){
        	HashMap<Point, Point> cameFrom = MyAstar.AStarSearch(neighbors,point,resolved_client);
        	Point a = cameFrom.get(resolved_client);
        	System.out.println(a.getDistance());		// show distance
        }
    }
}