package org.joedan.view;

import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import org.joedan.model.JobOverviewModel;

/**
 */
public class JobOverviewView extends VerticalLayout {

	private final org.joedan.model.JobOverviewModel model;

	public JobOverviewView() {
		// initialize the underlying model for the view
		model = new org.joedan.model.JobOverviewModel();
	}

	@Override
	public void attach() {
		super.attach();

		Table table = new Table();

		// set container on table
		table.setContainerDataSource(model.getContainer());

		// set visible columns and their order
		table.setVisibleColumns(model.getColumns());

		// set captions
		table.setColumnHeaders(model.getCaptions());

		// attach table to layout
		addComponent(table);
	}
}
