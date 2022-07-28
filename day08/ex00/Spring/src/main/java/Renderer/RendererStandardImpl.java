package Renderer;

import PreProcessor.PreProcessor;

public class RendererStandardImpl implements Renderer{
    public PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void render(String message) {
        System.out.println(preProcessor.processor(message));
    }
}
