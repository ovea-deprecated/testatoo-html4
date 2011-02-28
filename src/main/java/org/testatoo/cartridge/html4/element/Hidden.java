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

import static org.testatoo.cartridge.html4.element.HtmlElementType.Hidden;

/**
 * This class allows the testing of the "input" element (with "hidden" type)  properties,  for html4.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#edef-INPUT"> "input" specification </a>
 */

public final class Hidden extends org.testatoo.core.component.Field implements Coreattrs, I18n {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "input" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "input" element
     * @throws ComponentException if the given id does not correspond to a "input" element with type="hidden"
     */
    public Hidden(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Hidden) {
            throw new ComponentException("The component with id=" + id + " is not a " + Hidden + " but a " + evaluator.htmlElementType(id));
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
     * To get the type attribute of the "input" element, that is "hidden".
     *
     * @return the hidden type of the "input" element
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-type-INPUT">W3C recommendation</a>
     */
    public InputType type() {
        return InputType.hidden;
    }

    /**
     * To get the name attribute of the hidden element.
     * Name can be used to associate a name to the hidden element so that it can be processed by a form-handling script.
     *
     * @return the name of the hidden element
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-name-INPUT">W3C recommendation</a>
     */
    public String name() {
        return attributeSupport.name(this);
    }

    /**
     * To get the alt attribute of the hidden element.
     * Alt is used to set the alternative text of the image, but it exists in W3C specification for all types of input.
     *
     * @return the alt of the hidden element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-alt">W3C recommendation</a>
     */
    public String alt() {
        return attributeSupport.alt(this);
    }

    /**
     * To get the tabindex attribute of the hidden element.
     * Tabindex can be used to specify where the hidden element is in the tab order of the page.
     *
     * @return the tabindex of the hidden element
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-tabindex">W3C recommendation</a>
     */
    public int tabindex() {
        return attributeSupport.tabindex(this);
    }

    /**
     * To get the accesskey attribute of the hidden.
     * Accesskey can be used to associate a particular keyboard shortcut to the hidden (shoudn't be used...).
     *
     * @return the accesskey of the hidden
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-accesskey">W3C recommendation</a>
     */
    public String accesskey() {
        return attributeSupport.accesskey(this);
    }

    /**
     *
     * Hidden field has no label
     *
     * @return empty string
     */
    @Override
    public String label() {
        return "";
    }
}
