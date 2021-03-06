/*
 * Copyright (C) 2011 René Jeschke <rene_jeschke@yahoo.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.quanqi.mark4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Simple class for processing markdown files on the command line.
 * 
 * <p>
 * Usage:
 * </p>
 * 
 * <pre>
 * <code>java -cp txtmark.jar txtmark.Run filename [header_footer_file]
 * </code>
 * </pre>
 * 
 * <p>
 * The <code>header_footer_file</code> is an optional UTF-8 encoded file
 * containing a header and a footer to output around the generated HTML code.
 * </p>
 * 
 * <p>
 * Example:
 * </p>
 * 
 * <pre>
 * <code>&lt;?xml version="1.0" encoding="UTF-8"?>
 * &lt;!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 *                       "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
 * &lt;html xmlns="http://www.w3.org/1999/xhtml">
 * &lt;head>
 * &lt;title>markdown&lt;/title>
 * &lt;link type="text/css" href="style.css" rel="stylesheet"/>
 * &lt;meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
 * &lt;/head>
 * &lt;body>
 * &lt;!-- the following line separates header from footer -->
 * &lt;!-- ### -->
 * &lt;/body>
 * &lt;/html>
 * </code>
 * </pre>
 * 
 * @author René Jeschke <rene_jeschke@yahoo.de>
 */
public class Run
{
    /**
     * Static main.
     * 
     * @param args
     *            Program arguments.
     * @throws java.io.IOException
     *             If an IO error occurred.
     */
    public static void main(String[] args) throws IOException
    {
        // This is just a _hack_ ...
        BufferedReader reader = null;
        if(args.length == 0)
        {
            System.err.println("No input file specified.");
            System.exit(-1);
        }
        if(args.length > 1)
        {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[1]), "UTF-8"));
            String line = reader.readLine();
            while(line != null && !line.startsWith("<!-- ###"))
            {
                System.out.println(line);
                line = reader.readLine();
            }
        }
        System.out.println(Processor.process(new File(args[0])));
        if(args.length > 1 && reader != null)
        {
            String line = reader.readLine();
            while(line != null)
            {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        }
    }
}
