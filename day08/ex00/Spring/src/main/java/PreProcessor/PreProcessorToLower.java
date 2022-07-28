package PreProcessor;

public class PreProcessorToLower implements PreProcessor{
    @Override
    public String processor(String message) {
        return message.toLowerCase();
    }
}
