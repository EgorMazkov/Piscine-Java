package PreProcessor;

public class PreProcessorToUpperImpl implements PreProcessor{
    @Override
    public String processor(String message) {
        return message.toUpperCase();

    }
}
