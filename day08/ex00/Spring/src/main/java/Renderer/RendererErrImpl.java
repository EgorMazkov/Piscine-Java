package Renderer;

import PreProcessor.PreProcessor;

public class RendererErrImpl implements Renderer{
    public PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void render(String message) {
        System.err.println(preProcessor.processor(message));
    }
}
