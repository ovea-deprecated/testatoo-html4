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

import static org.testatoo.cartridge.html4.element.HtmlElementType.TextArea;

/**
 * This class allows the testing of the "textarea" element properties for html4.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#edef-TEXTAREA"> "textarea" specification </a>
 */

public final class TextArea extends org.testatoo.core.component.TextField implements Coreattrs, I18n {

    private HtmlEvaluator evaluator;
    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the textarea element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the textarea element
     * @throws ComponentException if the given id does not correspond to a "textarea" element
     */
    public TextArea(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != TextArea) {
            throw new ComponentException("The component with id=" + id + " is not a " + TextArea + " but a " + evaluator.htmlElementType(id));
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
     * To get the value attribute of the textarea (the content)
     *
     * @return the value of the "textarea" element
     */
    @Override
    public String value() {
        return evaluator.value(this);
    }

    /**
     * To get the rows attribute of the textarea (number of viewable rows).
     *
     * @return the row of the "textarea" element
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-rows-TEXTAREA">W3C recommendation</a>
     */
    public int rows() {
        return attributeSupport.rows(this);
    }

    /**
     * To get the cols attribute of the textarea (number of viewable columns).
     *
     * @return the cols of the "textarea" element
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-cols-TEXTAREA">W3C recommendation</a>
     */
    public int cols() {
        return attributeSupport.cols(this);
    }

    /**
     * To get the name attribute of the textarea.
     *
     * @return the name of the textarea
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-name-TEXTAREA">W3C recommendation</a>
     */
    public String name() {
        return attributeSupport.name(this);
    }

    /**
     * To get the readonly attribute of the textarea.
     *
     * @return true if the textarea cannot be modified
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-readonly">W3C recommendation</a>
     */
    public boolean isReadOnly() {
        return evaluator.isReadOnly(this);
    }

    /**
     * To get the tabindex attribute of the textarea.
     * Tabindex can be used to specify where the textarea is in the tab order of the page.
     *
     * @return the tabindex of the textarea
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-tabindex">W3C recommendation</a>
     */
    public int tabindex() {
        return attributeSupport.tabindex(this);
    }

    /**
     * To get the accesskey attribute of the textarea.
     * Accesskey can be used to associate a particular keyboard shortcut to the textarea.
     *
     * @return the accesskey of the textarea
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-accesskey">W3C recommendation</a>
     */
    public String accesskey() {
        return attributeSupport.accesskey(this);
    }
}
