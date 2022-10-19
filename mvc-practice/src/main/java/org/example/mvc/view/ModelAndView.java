package org.example.mvc.view;

public class ModelAndView {
    private final Object viewName;

    public ModelAndView(Object viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return this.viewName instanceof String ? (String) this.viewName : null;
    }
}
