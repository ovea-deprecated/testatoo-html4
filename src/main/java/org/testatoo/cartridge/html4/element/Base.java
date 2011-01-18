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

import static org.testatoo.cartridge.html4.element.HtmlElementType.Base;

/**
 * This class allows the testing of the "base" element properties for html4.
 * Base Defines the base location for links on a page.
 * Relative links within a document will become relative to the URI specified in the base tag.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/links.html#edef-BASE"> "base" specification </a>
 */

public final class Base extends Component {
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "base" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "base" element
     * @throws ComponentException if the given id does not correspond to a "base" element
     */
    public Base(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;
        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Base) {
            throw new ComponentException("The component with id=" + id + " is not a " + Base + " but a " + evaluator.htmlElementType(id));
        }
    }


    /**
     * To get the href attribute of the "base" element.
     * Href is used to specify the location on the base URI.
     *
     * @return the href of the base
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-href-BASE">W3C recommendation</a>
     */
    public String href() {
        return attributeSupport.href(this);
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
     * To get the string describing the "base" element.
     *
     * @return string describing the "base" element
     */
    public String toString() {
        return super.toString() + ", reference:" + href();
    }
}
