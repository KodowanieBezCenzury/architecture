package com.kodowaniebezcenzury.subieslaw.stockprice.architecture;

import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ImportOption;

@AnalyzeClasses(packages = "org.subieslaw.finance", importOptions = { ImportOption.DoNotIncludeTests.class })
public class NamingConventionsTest {

        @ArchTest
        static ArchRule classes_should_not_have_demo_in_name = 
                classes()
                .that()
                .resideInAPackage("..demo..")
                .should()
                .haveSimpleNameNotContaining("Demo")
                .as("Classes should have meaningful names")
                .because("Names should have business meaning.");

        @ArchTest
        static ArchRule class_names_should_not_end_with_manager = 
                classes()
                .should()
                .haveSimpleNameNotEndingWith("Manager");

        @ArchTest
        static ArchRule interfaces_should_not_have_interface_in_name = 
                classes()
                .that()
                .areInterfaces()
                .should()
                .haveSimpleNameNotContaining("Interface")
                .because("We follow SRP and Inteface is already defined as class type.");

}
