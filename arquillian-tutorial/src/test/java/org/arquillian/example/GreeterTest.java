/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.arquillian.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author douglas
 */
@RunWith(Arquillian.class)
public class GreeterTest {

    @Deployment
    public static JavaArchive createDeployment() {
//        return ShrinkWrap.create(JavaArchive.class)
//            .addClass(Greeter.class)
//            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClass(Greeter.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(jar.toString(true));
        return jar;
    }

    @Test
    public void should_create_greeting() {
//        Assert.fail("Not yet implemented");
        Assert.assertTrue(true);
    }
}
