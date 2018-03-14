package com.fxb;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
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

import org.apache.maven.model.Build;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Goal which touches a timestamp file.
 *  执行这个Mojo之后的结果的名称，即在调用这个插件的人来看就是 执行完这个Mojo之后的"目标"
 * @goal myMojo
 * 这个插件将会在process-test-classes阶段执行。
 * @phase process-test-classes
 */
// @phase process-sources  #默认绑定到了process-source阶段。
//    myMojo #表示该Mojo的名字
public class MyMojo extends AbstractMojo {
  
    /**
     * @parameter expression="${project}"
     */
//     #Maven在运行时会通过依赖注入自动将客户工程对象赋给project字段(请参考Maven自己的IoC容器Plexus)
    private MavenProject project;
    
    @Override
    public void execute()
            throws MojoExecutionException {
//        wirte2File();
        String baseDir = project.getBasedir().toString();
        String name = project.getName();
        Build build = project.getBuild();
        String outputDirectory = build.getOutputDirectory();
        String sourceDirectory = build.getSourceDirectory();
        String info[] = {baseDir,name,outputDirectory,sourceDirectory};
        getLog().info("=============================");
        for(String item : info) {
            getLog().info("\t-------"+item);
        }
        getLog().info("==============================");
    
    }
   
}
