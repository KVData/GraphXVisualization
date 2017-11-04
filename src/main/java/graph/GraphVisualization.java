package graph;


import data.EdgeModel;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.List;

/**
 * Created by zuce wei on 2017/11/2.
 */
public class GraphVisualization {

    Graph graph;

    public GraphVisualization(){
        graph=new SingleGraph("dem01");
        graph.addAttribute("ui.stylesheet",
                "url(E:/研一/云计算/数据展示/GraphXVisualization/src/main/resources/stylesheet)");
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");
        graph.setAutoCreate(true);

//        Viewer viewer = graph.display(false);
//        View view = viewer.getDefaultView();

//        view.resizeFrame(800, 600);
//        view.setViewCenter(440000, 2503000, 0);
//        view.setViewPercent(0.25);

        graph.display();
    }

    public void  createGraph(List<EdgeModel> edgeModels){
        for(EdgeModel edgeModel:edgeModels){
            if(edgeModel.getCount()<=0){
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
            try {
                Thread.sleep(1000);
            }catch (Exception e){
            }
        }
    }
}
