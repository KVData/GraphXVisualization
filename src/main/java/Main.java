import data.EdgeModel;
import data.MongUtil;
import graph.GraphVisualization;

import java.util.List;

/**
 * Created by zuce wei on 2017/11/2.
 */
public class Main {
    public static void main(String args[]){
        List<EdgeModel> edgeModels= MongUtil.readEdge();
        GraphVisualization graph=new GraphVisualization();
        graph.createGraph(edgeModels);
    }
}
