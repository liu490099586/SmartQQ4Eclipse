/*
 * Copyright 2014-2017 ieclipse.cn.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.ieclipse.smartqq.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wb.swt.ResourceManager;

import cn.ieclipse.smartqq.console.ChatConsole;
import cn.ieclipse.smartqq.views.LetterImageFactory;

/**
 * 类/接口描述
 * 
 * @author Jamling
 * @date 2017年8月14日
 *       
 */
public class FileAction extends Action {
    private ChatConsole fConsole;
    
    public FileAction(ChatConsole console) {
        this.fConsole = console;
        setText("Send file");
        setToolTipText("Send image or file");
        setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
                .getImageDescriptor(ISharedImages.IMG_OBJ_FILE));
    }
    
    @Override
    public void run() {
        if (fConsole != null) {
            FileDialog dialog = new FileDialog(
                    fConsole.getPage().getSite().getShell(), SWT.OPEN);
            String file = dialog.open();
            if (file != null) {
                fConsole.sendFile(file);
            }
        }
    }
}
