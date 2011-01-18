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

import static org.testatoo.cartridge.html4.element.HtmlElementType.Option;

/**
 * This class allows the testing of the "option" element properties for html4.
 * Option is an item in a "select" element.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#edef-OPTION"> "option" specification </a>
 */

public final class Option extends org.testatoo.core.component.Field implements Coreattrs, I18n {

    private HtmlEvaluator htmlEvaluator;
    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "option" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "option" element
     * @throws ComponentException if the given id does not correspond to a "option" element
     */
    public Option(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        htmlEvaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Option) {
            throw new ComponentException("The component with id=" + id + " is not a " + Option + " but a " + evaluator.htmlElementType(id));
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
     * To get the label attribute of the "option" element.
     *
     * @return the label attribute of the "option" element
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-label-OPTION">W3C recommendation</a>
     */
    public String label() {
        return htmlEvaluator.label(this);
    }

    @Override
    public String value() {
        String value = super.value();
        if (value.isEmpty()) {
            return content();
        }
        return value;
    }

    /**
     * To know if is the option is selected.
     *
     * @return true if the option is selected
     */
    public boolean selected() {
        return htmlEvaluator.selected(this);
    }

    /**
     * To get the content of the option.
     *
     * @return the content of the option
     */
    public String content() {
        return htmlEvaluator.content(this);
    }

    /**
     * To get the string describing the option.
     *
     * @return string describing the option
     */
    public String toString() {
        return super.toString() + ", text:" + content() + ", selected:" + selected();
    }
}
