package com.api.cdcapi.views.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;

import com.api.cdcapi.views.ComponentHelpers;

public class UploadComponent extends Upload {

    private ComponentHelpers componentHelpers;
    private Upload upload;
    
    public UploadComponent() {

        // ##### UPLOAD ##### //
        MemoryBuffer buffer = new MemoryBuffer();
        this.upload = new Upload(buffer);
        Div output = new Div();

        upload.addSucceededListener(event -> {
            Component component = componentHelpers.createComponent(event.getMIMEType(),
                    event.getFileName(), buffer.getInputStream());
            output.removeAll();
            componentHelpers.showOutput(event.getFileName(), component, output);
        });

        upload.addFileRejectedListener(event -> {
            Paragraph component = new Paragraph();
            output.removeAll();
            componentHelpers.showOutput(event.getErrorMessage(), component, output);
        });
        upload.getElement().addEventListener("file-remove", event -> {
            output.removeAll();
        });
    }

}
