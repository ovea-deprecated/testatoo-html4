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
import org.testatoo.core.component.Component;
import org.testatoo.core.nature.Container;
import org.testatoo.core.nature.LabelSupport;
import org.testatoo.core.nature.TitleSupport;

import java.util.ArrayList;
import java.util.List;

import static org.testatoo.cartridge.html4.element.HtmlElementType.OptionGroup;
import static org.testatoo.cartridge.html4.element.HtmlElementType.Undefined;

/**
 * This class allows the testing of the "optgroup" element properties for html4.
 * Optgroup defines a group of option elements in a select form field..
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#edef-OPTGROUP"> "optgroup" specification </a>
 */

public final class OptionGroup extends Component implements Coreattrs, I18n, Container, LabelSupport, TitleSupport {

    private HtmlEvaluator evaluator;
    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "optgroup" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "optgroup" element
     * @throws ComponentException if the given id does not correspond to a "optgroup" element
     */
    public OptionGroup(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != OptionGroup && evaluator.htmlElementType(id) != Undefined) {
            throw new ComponentException("The component with id=" + id + " is not a " + OptionGroup + " but a " + evaluator.htmlElementType(id));
        }
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
     * To know if the option group contains all the given components.
     *
     * @param components components we want to know if contained in the option group
     * @return True if all the components is contained in the option group
     */
    public Boolean contains(Component... components) {
        return evaluator.contains(this, components);
    }

    /**
     * To get the label attribute of the "optgroup" element.
     *
     * @return the label attribute of the "optgroup" element
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-label-OPTGROUP">W3C recommendation</a>
     */
    public String label() {
        return evaluator.label(this);
    }

    /**
     * To get the list of options of the "optgroup" element.
     *
     * @return the list of options
     */
    public Selection<Option> options() {
        return evaluator.options(this);
    }

    /**
     * To know if the component is visible
     * Always return false (not visible element)
     *
     * @return always return false
     */
    @Override
    public Boolean isVisible() {
        return false;
    }

    /**
     * To get the string describing the option group.
     *
     * @return string describing the option group
     */
    @Override
    public String toString() {
        return super.toString() + ", label:" + label() + ", optionsValue:" + optionsValue();
    }


    private Selection<String> optionsValue() {
        List<String> optionsValue = new ArrayList<String>();
        for (Option option : options()) {
            optionsValue.add(option.value());
        }
        return ListSelection.from(optionsValue);
    }
}
