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
import org.testatoo.core.component.Component;

import static org.testatoo.cartridge.html4.element.HtmlElementType.Label;

/**
 * This class allows the testing of the "label" element properties for html4.
 * Label is used ofr input, textarea or select elements.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#edef-LABEL"> "label" specification </a>
 */

public final class Label extends Component implements Coreattrs, I18n {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;
    private HtmlEvaluator evaluator;

    /**
     * Class constructor specifying the evaluator to use and the id of the "label" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "label" element
     * @throws ComponentException if the given id does not correspond to a "label" element
     */
    public Label(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        attributeSupport = new AttributeSupport(evaluator);
        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);

        if (evaluator.htmlElementType(id) != Label) {
            throw new ComponentException("The component with id=" + id + " is not a " + Label + " but a " + evaluator.htmlElementType(id));
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
     * To get the "for" attribute of the label.
     * "for" can be used to associate the label to a form element when the value of for matches the value of an element's id attribute.
     *
     * @return the id of the control associated to the label
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-for">W3C recommendation</a>
     */
    public String _for() {
        return attributeSupport._for(this);
    }

    /**
     * To get the accesskey attribute of the label.
     * Accesskey can be used to associate a particular keyboard shortcut to the label.
     *
     * @return the accesskey of the label
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-accesskey">W3C recommendation</a>
     */
    public String accesskey() {
        return attributeSupport.accesskey(this);
    }

    /**
     * To get the content of the label.
     *
     * @return the content of the label
     */
    public String content() {
        return evaluator.nodeTextContent(this);
    }

    /**
     * To get the string describing the label.
     *
     * @return string describing the label and its content
     */
    @Override
    public String toString() {
        return super.toString() + ", content: " + content();
    }


}
