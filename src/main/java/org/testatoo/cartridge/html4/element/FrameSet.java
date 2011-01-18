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

import static org.testatoo.cartridge.html4.element.HtmlElementType.FrameSet;

/**
 * This class allows the testing of the "frameset" element properties for html4.
 * The frameset section of a document specifies the layout of views in the main user agent window.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/present/frames.html#edef-FRAMESET"> frameset specification </a>
 */

public class FrameSet extends Component implements Coreattrs {

    private CoreAttributeSupport coreAttributeSupport;
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "frameset" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "frameset" element
     * @throws ComponentException if the given id does not correspond to a "frameset" element
     */
    public FrameSet(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != FrameSet) {
            throw new ComponentException("The component with id=" + id + " is not a " + FrameSet + " but a " + evaluator.htmlElementType(id));
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
     * To get the cols attribute of the frameset.
     * It specifies the layout of vertical frames.
     *
     * @return the cols of the "frameset" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-cols-FRAMESET">W3C recommendation</a>
     */
    public String cols() {
        return attributeSupport.framesetCols(this);
    }

    /**
     * To get the rows attribute of the frameset.
     * It specifies the layout of horizontal frames.
     *
     * @return the rows of the "frameset" element
     * @see <a href="http://www.w3.org/TR/html401/present/frames.html#adef-rows-FRAMESET">W3C recommendation</a>
     */
    public String rows() {
        return attributeSupport.framesetRows(this);
    }

    /**
     * To get the string describing the frameset
     *
     * @return string describing the frameset
     */
    public String toString() {
        return super.toString() + ", title:" + title();
    }
}
