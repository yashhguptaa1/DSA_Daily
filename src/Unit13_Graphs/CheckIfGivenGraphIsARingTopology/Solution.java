package Unit13_Graphs.CheckIfGivenGraphIsARingTopology;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static boolean checkRingTopology(ArrayList<Integer>startPts,ArrayList<Integer>endPts)
    {
        int Vertices=startPts.size();

        Graph ring=new Graph(Vertices);

        for(int i=0;i<Vertices;i++)
        {
            ring.addEdge(startPts.get(i),endPts.get(i));
        }

        //ring.printAdjacencyList();

        boolean allDegree2=true;

        for(int i=0;i<Vertices;i++)
        {
            int degree=ring.adjacencyList.get(i).size();
            if(degree!=2)
            {
                allDegree2=false;
                break;
            }

        }


        if(Vertices>=3 &&
                allDegree2 &&
                ring.countEdges()==Vertices)
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

        if(checkRingTopology(startingPts,endingPts))
            System.out.println("Its A Ring Topology");


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
