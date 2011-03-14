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

package org.testatoo.cartridge.html4;

import com.thoughtworks.selenium.Selenium;
import org.testatoo.cartridge.html4.element.*;
import org.testatoo.cartridge.html4.element.Object;
import org.testatoo.core.Evaluator;
import org.testatoo.core.Selection;
import org.testatoo.core.component.Component;
import org.testatoo.core.component.Field;


/**
 * This interface gives the methods that an html Evaluator must have, whatever UI Test engine used
 *
 * @author dev@testatoo.org
 */

public interface HtmlEvaluator extends Evaluator<Selenium> {

    /**
     * To get the value of an attribute of the html element with a given id
     *
     * @param id        the id of the html element
     * @param attribute the attribute
     * @return the string corresponding to the value of the attribute of the html element
     */
    String attribute(String id, Attribute attribute);

    /**
     * To open the page corresponding to the given url
     *
     * @param url the url of the page
     */
    void open(String url);

    /**
     * To get the current page source
     *
     * @return the page source
     */
    String pageSource();

    /**
     * To get the options in a given select.
     *
     * @param select the given select
     * @return a list of options
     */
    Selection<Option> options(Select select);

    /**
     * To get the option groups in a given select.
     *
     * @param select the given select
     * @return a list of option groups
     */
    Selection<OptionGroup> optionGroups(Select select);

    /**
     * To get the selected options in a given select
     *
     * @param select the list
     * @return the list of selected Options
     */
    Selection<Option> selectedOptions(Select select);

    /**
     * To get the options in a given option group.
     *
     * @param optionGroup the given option group
     * @return a list of Options
     */
    Selection<Option> options(OptionGroup optionGroup);

    /**
     * To get the parameters of a given object.
     *
     * @param object the given object
     * @return a list of Params
     */
    Selection<Param> params(Object object);

    /**
     * To get the areas on a given map.
     *
     * @param map the given map
     * @return a list of Areas
     */
    Selection<Area> areas(Map map);

    /**
     * To know if an option is selected.
     *
     * @param option the given option
     * @return true if the option is selected
     */
    Boolean selected(Option option);

    /**
     * To get the content of a given option.
     *
     * @param option the given option
     * @return the content as a string
     */
    String content(Option option);

    /**
     * To get the label of a given option.
     *
     * @param option the given option
     * @return the label of the option
     */
    String label(Option option);

    /**
     * To get the label of a given option group.
     *
     * @param optionGroup the given option group
     * @return the label of the option group
     */
    String label(OptionGroup optionGroup);

    /**
     * To submit a given form.
     *
     * @param form the given form
     */
    void submit(Form form);

    /**
     * To reset a given form.
     *
     * @param form the given form
     */
    void reset(Form form);

    /**
     * To know if a field is read-only.
     *
     * @param field the given field
     * @return true if the field is read-only
     */
    Boolean isReadOnly(Field field);

    /**
     * To get the id of the html element corresponding to a given path
     *
     * @param path the path for the html element
     * @return the id of the html element
     */
    String elementId(String path);

    /**
     * To get the ids of the html elements corresponding to a given path
     *
     * @param path the path for the html elements
     * @return the list of ids of the html elements
     */
    String[] elementsId(String path);

    /**
     * To get the html type of the element with a given id
     *
     * @param id the id of the html element
     * @return the html type of the html element
     */
    HtmlElementType htmlElementType(String id);

    /**
     * To get the columns in a given colgroup
     *
     * @param colgroup the given colgroup
     * @return the list of Cols
     */
    Selection<Col> cols(Colgroup colgroup);

    /**
     * To get the caption of a given table
     *
     * @param table the given table
     * @return the Caption of the table
     */
    Caption caption(Table table);

    /**
     * To get the content of a given component
     *
     * @param component the given component
     * @return the content of the component
     */
    String content(Component component);

    /**
     * To get the Thead of a given table
     *
     * @param table the given table
     * @return the THead of the table
     */
    THead thead(Table table);

    /**
     * To get the Tbody of a given table
     *
     * @param table the given table
     * @return the TBody of the table
     */
    TBody tbody(Table table);

    /**
     * To get the columns of a given table
     *
     * @param table the given table
     * @return the list of Cols of the table
     */
    Selection<Col> cols(Table table);

    /**
     * To get the columns groups of a given table
     *
     * @param table the given table
     * @return the list of Colgroup of the table
     */
    Selection<Colgroup> colgroups(Table table);

    /**
     * To get the Tfoot of a given table
     *
     * @param table the given table
     * @return the TFoot of the table
     */
    TFoot tfoot(Table table);

    /**
     * To get the tr elements of a given component (Table, TBody, THead or TFoot)
     *
     * @param component the given component
     * @return the list of Tr of the component
     */
    Selection<Tr> tr(Component component);

    /**
     * To get the td elements of a given Tr
     *
     * @param tr the given Tr
     * @return the list of Td of the Tr
     */
    Selection<Td> td(Tr tr);

    /**
     * To get the th elements of a given Tr
     *
     * @param tr the given Tr
     * @return the list of Th of the Tr
     */
    Selection<Th> th(Tr tr);

    /**
     * To get the content of a given component.
     *
     * @param component the given component
     * @return the content of the component
     */
    String nodeTextContent(Component component);

    /**
     * To know if an attribute is present for a given component.
     *
     * @param id        the id of the component
     * @param attribute the attribute we want to know if present
     * @return true if attribute is present
     */
    Boolean exist(String id, Attribute attribute);

    /**
     * To know the nodename for a given component.
     *
     * @param component the given component
     * @return the nodename of the component
     */
    String nodename(Component component);


    String pageId();
}
