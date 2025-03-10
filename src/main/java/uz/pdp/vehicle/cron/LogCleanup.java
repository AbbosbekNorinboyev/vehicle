package uz.pdp.vehicle.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

@Component
public class LogCleanup {
    private static final Logger logger = LoggerFactory.getLogger(LogCleanup.class);
    private static final String LOG_PATH = "C:\\Abbos\\Spring Project\\Test Projects\\Vehicle\\logs\\Logs.log";

    @Scheduled(cron = "* */5 * * * *") // har 5 minutda log faylni tozalaydi
    public void clearLogFile() {
        File file = new File(LOG_PATH);
        if (file.exists()) {
            try {
                Files.write(file.toPath(), new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
                logger.info("✅ Log fayl tozalandi: " + LOG_PATH);
                System.out.println("clearLogFile sihlamoqda.............");
            } catch (IOException e) {
                logger.error("❌ Log faylni tozalashda xatolik: " + e.getMessage());
            }
        } else {
            logger.warn("⚠ Log fayl topilmadi");
        }
    }
}
