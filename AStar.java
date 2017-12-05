import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class AStar {
	
		public double Heuristic(Point a, Point c)
        {
            return Math.sqrt( (Math.abs(a.x - c.x) + Math.abs(a.y - c.y)) );
        }
        
        public double Distance(Point a, Point b)
        {
            return Math.sqrt( (Math.abs(a.x - b.x) + Math.abs(a.y - b.y)) );
        }

        public HashMap<Point, Point> AStarSearch(HashMap<Point, ArrayList<Point>> neighbors, Point start, Point goal)
        {
        	HashMap<Point, Point>  cameFrom = new HashMap< Point, Point>();
        	TreeSet<Point> MyTreeSet = new TreeSet<Point>(new MyComparator());
        	HashMap< Point, Point > visited = new HashMap< Point, Point >();
			start.setDistance(0);
			start.setHeuristic( Heuristic(start,goal) );
			MyTreeSet.add(start);
			ArrayList<Point> temp = new ArrayList<>();
			Point head = start;		// head of treeSet, initially equal to start
		
			while( !(head.getX()==goal.getX() && head.getY()==goal.getY()) ){
				head = MyTreeSet.pollFirst();
				System.out.println(head.getX() + " " + head.getY());
				visited.put(head,head); 						// set head visited
				temp = neighbors.get(head);
				if(temp!=null){
					for (Point p: temp ) {
						if( !visited.containsValue(p) ){			// if not visited
							p.setHeuristic( Heuristic(p, goal) );
							p.setDistance(head.getDistance() + Distance(head, p));
							MyTreeSet.add(p);
							cameFrom.put(p, head);
						}
					}
				}
			}
			return cameFrom;
        }

}
