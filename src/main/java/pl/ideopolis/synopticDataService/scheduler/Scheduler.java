package pl.ideopolis.synopticDataService.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Component;
import pl.ideopolis.synopticDataService.synopticData.SynopticDataService;
import pl.ideopolis.synopticDataService.utils.JsonUtil;
import pl.ideopolis.synopticDataService.utils.SaveToFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final SynopticDataService synopticDataService = new SynopticDataService();

    @Scheduled(fixedRate = 1200000)
    public void reportCurrentTime(){
        log.info("The time is now {}", dateFormat.format(new Date()));
        String jsonAsString = synopticDataService.getPostPlainJSON();

        JsonUtil jsonUtil = new JsonUtil(jsonAsString);
        SaveToFile saveToFile = new SaveToFile();

        String fileName;
        fileName = jsonUtil.getValue("data_pomiaru")+" "+jsonUtil.getValue("godzina_pomiaru")+".txt";
        System.out.println("file name: "+fileName);
        saveToFile.saveToFile(fileName, "D:\\test\\", jsonUtil.asText());
    }

}
