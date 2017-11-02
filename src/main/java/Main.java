import data.EdgeModel;
import data.MongUtil;
import graph.GraphVisualization;
import org.graphstream.graph.Graph;

import java.util.List;

/**
 * Created by zuce wei on 2017/11/2.
 */
public class Main {
    public static void main(String args[]){
        List<EdgeModel> edgeModels= MongUtil.readEdge();
        Graph graph= GraphVisualization.creatGraph(edgeModels);
        graph.display();
    }
}
