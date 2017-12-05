public class Point {
        double  x;
        double  y;
        int     id;
        double heuristic;
        double distance;
        Point(String[] attributes){
                x = Double.parseDouble(attributes[0]);
                y = Double.parseDouble(attributes[1]);
                id = Integer.parseInt(attributes[2]);
        }
        Point(){}


        public double getX() {
                return x;
        }
        public double getY() {
                return y;
        }
        public int getId() {
            return id;
        }
        public double getDistance(){
        	return distance;
        }
        public void setX(double i){
        	this.x=i;
        }
        public void setY(double i){
        	this.y=i;
        }
        public void setId(int i){
        	this.id=i;
        }
        public void setHeuristic(double h){
        	this.heuristic=h;
        }
        public void setDistance(double d){
        	this.distance = d;
        }
                  
        // this may need to change to long
        @Override
        public int hashCode() {
               return Double.valueOf(this.x /** Math.pow(10,9)*/ + this.y).hashCode();
        }
       
        public boolean equals(Point o)
        {
                if (this.x != o.x) return false;
                if (this.y != o.y) return false;
                return true;
        }

}