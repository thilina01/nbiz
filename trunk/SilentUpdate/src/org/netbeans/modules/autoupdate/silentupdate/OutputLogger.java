/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2010 Sun
 * Microsystems, Inc. All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */
package org.netbeans.modules.autoupdate.silentupdate;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.util.NbBundle;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;

/**
 *
 * @author Jiri Rechtacek
 */
public final class OutputLogger {
    
    // to log all messages for whole package
    private static final Logger LOGGER = Logger.getLogger(OutputLogger.class.getPackage().getName());
    private static Grain grain;
    private static final String OUTPUT_LOGGER_NAME = NbBundle.getMessage(OutputLogger.class, "OutputLoggerWindow.Name"); // NOI18N
    private static InputOutput io;

    private enum Grain {
        VERBOSE,
        WINDOW,
        LOG,
        SILENT
    }
    private static final Grain DEFAULT = Grain.LOG;

    private static Grain grain() {
        if (grain == null) {
            String s = NbBundle.getBundle("org.netbeans.modules.autoupdate.silentupdate.resources.Bundle").getString("OutputLogger.Grain");
            grain = DEFAULT;
            try {
                grain = Grain.valueOf(s);
            } catch (IllegalArgumentException x) {
                LOGGER.info(s);
            }
        }

        return grain;
    }

    public static void log(String msg, Throwable... x) {
        log(Level.INFO, msg, x);
    }

    @SuppressWarnings("fallthrough")
    public static void log(Level l, String msg, Throwable... x) {
        switch(grain()) {
            case VERBOSE:
                if (x == null) {
                    LOGGER.log(Level.INFO, msg);
                } else {
                    LOGGER.log(Level.INFO, msg);
                    for (Throwable t : x) {
                        LOGGER.log(Level.INFO, msg, t);
                    }
                }
                break;
            case WINDOW:
                try {
                    InputOutput output = getIO();
                    if (x == null) {
                        output.getOut().println(msg);
                        output.getOut().close();
                    } else {
                        output.getErr().println(msg);
                        for (Throwable t : x) {
                            output.getErr().println(t);
                        }
                        output.getErr().close();
                    }
                } catch (Exception ex) {
                    LOGGER.log(Level.INFO, ex.getLocalizedMessage(), ex);
                }
                // use LOGGER for these message too
            case LOG:
                if (LOGGER.isLoggable(l)) {
                    if (x == null) {
                        LOGGER.log(l, msg);
                    } else {
                        LOGGER.log(l, msg);
                        for (Throwable t : x) {
                            LOGGER.log(l, msg, t);
                        }
                    }
                }
                break;
            case SILENT:
                if (x == null) {
                    LOGGER.log(Level.FINEST, msg);
                } else {
                    LOGGER.log(Level.FINEST, msg);
                    for (Throwable t : x) {
                        LOGGER.log(Level.FINEST, msg, t);
                    }
                }
                break;
            default:
                assert false : "Unkown grain " + grain();
        }
    }

    private static synchronized InputOutput getIO () {
        if (io == null) {
            io = IOProvider.getDefault().getIO(OUTPUT_LOGGER_NAME, true);
        }
        return io;
    }

}
