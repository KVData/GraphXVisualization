package graph;


import data.EdgeModel;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.List;

/**
 * Created by zuce wei on 2017/11/2.
 */
public class GraphVisualization {

    public static Graph creatGraph(List<EdgeModel> edgeModels){
       Graph graph=new SingleGraph("dem01");
        for(EdgeModel edgeModel:edgeModels){
            if(edgeModel.getCount()<=120){
                continue;//跳过边的值为1 的情况
            }
            //构建起点
            if(graph.getNode(edgeModel.getFrom())==null){
                graph.addNode(edgeModel.getFrom()).addAttribute("ui.label",edgeModel.getFrom());
            }
            //构建终点
            if(graph.getNode(edgeModel.getTo())==null){
                graph.addNode(edgeModel.getTo()).addAttribute("ui.label",edgeModel.getTo());
            }
            //构建边
            if(graph.getEdge(edgeModel.getFrom()+"-"+edgeModel.getTo())!=null){
                graph.getEdge(edgeModel.getFrom()+"-"+edgeModel.getTo())
                        .addAttribute("ui.label",edgeModel.getCount());
            }else{
              //  graph.removeEdge(graph.getEdge(edgeModel.getFrom()+"-"+edgeModel.getTo()));
                graph.addEdge(edgeModel.getFrom()+"-"+edgeModel.getTo(),
                        edgeModel.getFrom(),
                        edgeModel.getTo(),
                        true)   //设置方向，即有向图
                        .addAttribute("ui.label",edgeModel.getCount());
            }
        }
       return graph;
    }
}
