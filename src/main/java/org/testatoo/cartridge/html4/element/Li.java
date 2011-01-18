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

import static org.testatoo.cartridge.html4.element.HtmlElementType.Li;

/**
 * This class allows the testing of the "li" element properties for html4.
 * Ul defines an item in a li or ol list
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/lists.html#edef-LI"> "li" specification </a>
 */

public final class Li extends Component implements Coreattrs, I18n {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private HtmlEvaluator evaluator;


    /**
     * Class constructor specifying the evaluator to use and the id of the "li" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "li" element
     * @throws ComponentException if the given id does not correspond to a "li" element
     */
    public Li(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Li) {
            throw new ComponentException("The component with id=" + id + " is not a " + Li + " but a " + evaluator.htmlElementType(id));
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
     * To get the content of the "li" element.
     *
     * @return the content of the li
     */
    public String content() {
        return evaluator.content(this);
    }

    /**
     * To get the string describing the "li" element.
     *
     * @return string describing the "li" element
     */
    public String toString() {
        return super.toString() + ", title:" + title() + ", content:" + content();
    }
}

