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

import static org.testatoo.cartridge.html4.element.HtmlElementType.Script;

/**
 * This class allows the testing of the "script" element properties for html4.
 * Script is used to define a scripting language, such as JavaScript.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/interact/scripts.html#edef-SCRIPT"> "script" specification </a>
 */

public final class Script extends Component {
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "script" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "script" element
     * @throws ComponentException if the given id does not correspond to a "script" element
     */
    public Script(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;
        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Script) {
            throw new ComponentException("The component with id=" + id + " is not a " + Script + " but a " + evaluator.htmlElementType(id));
        }
    }

    /**
     * To get the charset attribute of the "script" element.
     * Charset can be used to specify the character set of the "script" element.
     *
     * @return the charset attribute of the "script" element
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-charset">W3C recommendation</a>
     */
    public String charset() {
        return attributeSupport.charset(this);
    }

    /**
     * To get the type attribute of the "script" element.
     * Type is used to specify what type of scripting language is used.
     * This takes the form of a MIME type such as text/javascript
     *
     * @return the type attribute of the "script" element
     * @see <a href="http://www.w3.org/TR/html401/interact/scripts.html#adef-type-SCRIPT">W3C recommendation</a>
     */
    public String type() {
        return attributeSupport.type(this);
    }

    /**
     * To get the src attribute of the "script" element.
     * Src can be used to specify an external source of a script file.
     *
     * @return the src attribute of the "script" element
     * @see <a href="http://www.w3.org/TR/html401/interact/scripts.html#adef-src-SCRIPT">W3C recommendation</a>
     */
    public String src() {
        return attributeSupport.src(this);
    }

    @Override
    public Boolean isVisible() {
        return Boolean.FALSE;
    }

    /**
     * To get the string describing the "script" element.
     *
     * @return string describing the "script" element
     */
    public String toString() {
        return super.toString() + ", source:" + src();
    }
}
