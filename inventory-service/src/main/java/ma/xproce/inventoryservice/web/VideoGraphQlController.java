package ma.xproce.inventoryservice.web;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.service.CreatorManager;
import ma.xproce.inventoryservice.service.VideoManager;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {
    private CreatorManager creatorManager;
    private VideoManager videoManager;

    VideoGraphQlController(CreatorManager creatorManager, VideoManager videoManager){
        this.creatorManager = creatorManager;
        this.videoManager = videoManager;
    }

    @QueryMapping
    public List<Video> videoList(){
        return videoManager.videoList();
    }

    @QueryMapping
    public Creator creatorById(@Argument Integer id){
        return creatorManager.creatorById(id);
    }
}
