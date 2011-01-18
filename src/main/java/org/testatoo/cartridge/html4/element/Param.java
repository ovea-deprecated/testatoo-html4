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

import static org.testatoo.cartridge.html4.element.HtmlElementType.Param;
import static org.testatoo.cartridge.html4.element.HtmlElementType.Undefined;

/**
 * This class allows the testing of the "param" element properties for html4.
 * Param is a parameter of an object.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#edef-PARAM"> param specification </a>
 */

public final class Param extends Component {
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "param" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "param" element
     * @throws ComponentException if the given id does not correspond to a "param" element
     */
    public Param(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Param && evaluator.htmlElementType(id) != Undefined) {
            throw new ComponentException("The component with id=" + id + " is not a " + Param + " but a " + evaluator.htmlElementType(id));
        }
    }

    /**
     * To get the name attribute of the parameter.
     *
     * @return the name of the "param" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-name-PARAM">W3C recommendation</a>
     */
    public String name() {
        return attributeSupport.name(this);
    }

    /**
     * To get the type attribute of the parameter.
     *
     * @return the type of the "param" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-type-PARAM">W3C recommendation</a>
     */
    public String type() {
        return attributeSupport.type(this);
    }

    /**
     * To get the value attribute of the parameter.
     *
     * @return the value of the "param" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-value-PARAM">W3C recommendation</a>
     */
    public String value() {
        return attributeSupport.value(this);
    }

    /**
     * To get the valuetype attribute of the parameter.
     *
     * @return the type of the value attribute of the "param" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-valuetype">W3C recommendation</a>
     */
    public ValueType valuetype() {
        return attributeSupport.valuetype(this);
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
     * To get the string describing the parameter.
     *
     * @return string describing the parameter
     */
    public String toString() {
        return super.toString() + ", name:" + name() + ", value:" + value();
    }
}

