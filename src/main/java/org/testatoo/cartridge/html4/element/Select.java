/**
 * Copyright (C) 2008 Ovea <dev@testatoo.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.testatoo.cartridge.html4.element;

import org.testatoo.cartridge.html4.HtmlEvaluator;
import org.testatoo.core.ComponentException;
import org.testatoo.core.ListSelection;
import org.testatoo.core.Selection;
import org.testatoo.core.nature.LabelSupport;
import org.testatoo.core.nature.MultiSelectable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class allows the testing of the "select" element properties for html4.
 * Select is a drop-down list ; each list item of a select is an option element.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#edef-SELECT"> "select" specification </a>
 */

public final class Select extends org.testatoo.core.component.ListModel implements MultiSelectable, LabelSupport, Coreattrs, I18n {

    private HtmlEvaluator evaluator;
    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "select" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "select" element
     */
    public Select(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
    }

    /**
     * To get the "label" corresponding to the "select" element
     * the label of the select is the content of the "label" element with a "for" attribute equals to the select id
     *
     * @return the content of label attribute corresponding to the "select" element
     */
    public String label() {
        return evaluator.label(this);
    }

    /**
     * @see CoreAttributeSupport
     */
    public String classname() {
        return coreAttributeSupport.classname(this);
    }

    /**
     * @see CoreAttributeSupport
     */
    public String style() {
        return coreAttributeSupport.style(this);
    }

    /**
     * @see CoreAttributeSupport
     */
    public String title() {
        return coreAttributeSupport.title(this);
    }

    /**
     * @see I18nAttributeSupport
     */
    public String language() {
        return i18nAttributeSupport.language(this);
    }

    /**
     * @see I18nAttributeSupport
     */
    public Direction direction() {
        return i18nAttributeSupport.direction(this);
    }

    /**
     * To get the selected values in the list.
     *
     * @return a list of String
     * @see #listSelectedValues
     */
    public Selection<String> selectedValues() {
        return lstSelectedValues();
    }

    /**
     * To get the selected values in the list.
     *
     * @return a list of String
     * @see #selectedValues
     */
    protected Selection<String> listSelectedValues() {
        return lstSelectedValues();
    }

    /**
     * To select in the list an item with a given value.
     * If the item has no value, the item with the content equals to the value is selected
     *
     * @param value the value of the item we want to select
     */
    public void select(String value) {
        evaluator.select(value, this);
    }

    /**
     * To unselect in the list an item with a given value.
     * If the item has no value, the item with the content equals to the value is deselected
     *
     * @param value the value of the item we want to unselect
     */
    public void unselect(String value) {
        if (isMultiple())
            evaluator.unselect(value, this);
        else
            throw new ComponentException("Unable to unselect a value : Select is no a multi select.");
    }

    /**
     * To get the values in the list.
     *
     * @return a list of String
     */
    public Selection<String> values() {
        List<String> optionsValue = new ArrayList<String>();
        for (Option option : options()) {
            optionsValue.add(option.value());
        }
        return ListSelection.from(optionsValue);
    }


    /**
     * To unselect all the selected values of the list.
     */
    public void unselectAll() {
        if (isMultiple())
            evaluator.unselectAll(this);
        else
            throw new ComponentException("Unable to unselect all values : Select is no a multi select.");
    }

    /**
     * To know if a list is multi-selectable.
     *
     * @return true if the list is multi-selectable
     */
    public boolean isMultiple() {
        return Boolean.valueOf(evaluator.attribute(id(), Attribute.multiple));
    }

    /**
     * To get the options in the list.
     *
     * @return a list of options
     */
    public Selection<Option> options() {
        return evaluator.options(this);
    }

    /**
     * To get the optiongroups in the list.
     *
     * @return a list of optionGroups
     */
    public Selection<OptionGroup> optionGroups() {
        return evaluator.optionGroups(this);
    }

    /**
     * To get the selected options in the list.
     *
     * @return a list of options
     */
    public Selection<Option> selectedOptions() {
        return evaluator.selectedOptions(this);
    }

    /**
     * To get the number of visible items of the list.
     *
     * @return the number of visible rows
     */
    public int visibleRows() {
        return size();
    }

    /**
     * To get the name attribute of the list.
     * name can be used so that the value of the selected option element can be processed.
     *
     * @return the name of the list
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-name-SELECT">W3C recommendation</a>
     */
    public String name() {
        return attributeSupport.name(this);
    }

    /**
     * To get the tabindex attribute of the list.
     * Tabindex can be used to specify where the element appears in the tab order of the page.
     *
     * @return the tabindex of the list
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-tabindex">W3C recommendation</a>
     */
    public int tabindex() {
        return attributeSupport.tabindex(this);
    }

    /**
     * To get the size attribute of the list.
     * Size corresponds to the number of visible rows.
     *
     * @return the size of the list
     * @see #visibleRows
     */
    public int size() {
        String size = evaluator.attribute(id(), Attribute.size);
        if (size.isEmpty())
            return 0;
        return Integer.valueOf(size);
    }

    /**
     * To get the string describing the list.
     *
     * @return string describing the list and its content
     */
    public String toString() {
        return super.toString() + ", optionGroup:" + Arrays.deepToString(optionGroupValues().toArray()) + ", visibleRows:" + visibleRows();
    }

    protected Selection<String> lstSelectedValues() {
        List<String> selectedValues = new ArrayList<String>();
        for (Option option : selectedOptions()) {
            selectedValues.add(option.value());
        }
        return ListSelection.from(selectedValues);
    }

    private List<String> optionGroupValues() {
        List<String> optionGroupValues = new ArrayList<String>();
        for (OptionGroup optionGroup : optionGroups()) {
            optionGroupValues.add(optionGroup.label());
        }
        return optionGroupValues;
    }
}
