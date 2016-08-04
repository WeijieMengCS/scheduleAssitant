public class fileAccessor{
    private static final String prefix = System.getProperty("user.home") + "/Desktop/Fun/time_scheduler/data/";

    public String getFilePath(String fileName){
        return prefix + fileName;
    }
}