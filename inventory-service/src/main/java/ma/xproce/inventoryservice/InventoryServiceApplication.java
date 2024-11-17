package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {
    @Autowired
    CreatorRepository creatorRepository;
    @Autowired
    VideoRepository videoRepository;
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(){
        return args ->{
            List<Creator> creators = List.of(
                    new Creator(1,"Assia", "assia@gmail.com", null),
                    new Creator(2,"Ali", "ali@gmail.com", null)
            );
            creatorRepository.saveAll(creators);

            int i=10;
            //List<Video> videos= new ArrayList<>();
            for(Creator creator : creators){
                List<Video> videos = List.of(
                        new Video(i,"Machine Learning and Its Impact on Everyday Life", "https://www.youtube.com/watch?v=NjVIQUE8Sgk",
                                "On this video you will learn the science behind ML or machine learning and a.i or artificial intelligence and what they are used for. ", LocalDate.now(), creator),
                        new Video(++i, "Machine Learning, AI, and the Future of Education", "https://www.youtube.com/watch?v=gjDPtzJQnyM",
                                "The speaker dives deep into how AI has revolutionized every industry, including education, and proposes a reimagined future for learning in the age of smart machines.", LocalDate.now(), creator)
                );
                i++;
                videoRepository.saveAll(videos);
            }
        };
    }
}
