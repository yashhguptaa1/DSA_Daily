package Unit13_Graphs.CheckIfGivenGraphIsABusTopology;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static boolean checkBusTopology(ArrayList<Integer>startPts,ArrayList<Integer>endPts,int n)
    {
        int Vertices=n;

        Graph ring=new Graph(Vertices);

        for(int i=0;i<Vertices;i++)
        {
            ring.addEdge(startPts.get(i),endPts.get(i));
        }

        //ring.printAdjacencyList();

        int degreeStartNode=ring.adjacencyList.get(startPts.get(0)).size();
        int degreeEndNode=ring.adjacencyList.get(startPts.get(Vertices-1)).size();

        int countDegree2=0;

        for(int i=1;i<Vertices-1;i++)
        {
            int degree=ring.adjacencyList.get(startPts.get(i)).size();
            if(degree==2)
            {
                countDegree2++;
            }

        }


        if(degreeStartNode==1&&
                degreeEndNode==1 &&
                countDegree2==Vertices-2&&
                ring.countEdges()==Vertices-1)
            return true;

        return false;
    }

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);

        int vertices=sc.nextInt();

        ArrayList<Integer>startingPts=new ArrayList<>();

        for(int i=0;i<vertices;i++)
        {
            startingPts.add(sc.nextInt());
        }

        ArrayList<Integer>endingPts=new ArrayList<>();

        for(int i=0;i<vertices;i++)
        {
            endingPts.add(sc.nextInt());
        }

        if(checkBusTopology(startingPts,endingPts,vertices))
            System.out.println("Its A Bus Topology");
    }
}
class Graph{

    ArrayList<ArrayList<Integer>> adjacencyList;
    int numOfVertices;

    Graph(int V)
    {
        this.numOfVertices=V;
        this.adjacencyList=new ArrayList<ArrayList<Integer>>(V);

        for(int i=0;i<V;i++)
        {
            adjacencyList.add(new ArrayList<>());
        }
    }

    void addEdge(int u,int v)
    {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    void printAdjacencyList()
    {
        for (int i=0;i<adjacencyList.size();i++)
        {
            System.out.print(i+"-> ");
            for(int j=0;j<adjacencyList.get(i).size();j++)
            {
                System.out.print(adjacencyList.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    int countEdges()
    {
        int sum=0;

        for(int i=0;i<numOfVertices;i++ )
        {
            sum+=adjacencyList.get(i).size();
        }
        // The count of edge is always even because in
        // undirected graph every edge is connected
        // twice between two vertices
        return sum / 2;
    }

}