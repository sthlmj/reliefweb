package org.joedan.model;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanContainer;
import org.joedan.client.JobsRepository;
import org.joedan.model.bean.reliefweb.JobData;

/**
 */
public class JobOverviewModel {

    public static final String PUBLISHED = "published";

    private final BeanContainer container;

    public JobOverviewModel() {
        container = new BeanContainer<Integer, JobData>(JobData.class);
        container.setBeanIdProperty("id");
        container.addAll(JobsRepository.getInstance().getJobs());
        container.addNestedContainerBean("fields");
        container.addNestedContainerBean("fields.city");
        container.addNestedContainerBean("fields.country");

        container.addContainerFilter(new Container.Filter() {
            @Override
            public boolean passesFilter(Object o, Item item) throws UnsupportedOperationException {
                final Property property = item.getItemProperty("fields.status");

                if (property != null) {
                    final String status = (String) property.getValue();

                    if (status.equals(PUBLISHED)) {
                        return true;
                    }
                }

                return false;
            }

            @Override
            public boolean appliesToProperty(Object o) {
                return false;
            }
        });
    }

    public Container getContainer() {
        return container;
    }

    /**
     * @return columns to display
     */
    public String[] getColumns() {
        return new String[]{"id", "fields.title"};
    }

    public String[] getCaptions() {
        return new String[]{"id", "title"};
    }

}
