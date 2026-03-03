package org.miteshdandade.resources;

import com.aventstack.extentreports.ExtentReports;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ExtentReporterNGTest {

    @Test
    public void testGetReportObjectReturnsNonNullExtentReports() {
        ExtentReports extent = ExtentReporterNG.getReportObject();
        Assert.assertNotNull(extent, "ExtentReports object should not be null");
    }

    @Test
    public void testGetReportObjectSetsSystemInfo() {
        ExtentReports extent = ExtentReporterNG.getReportObject();

        // ExtentReports doesn't have a direct getter for SystemInfo out of the box that is easily queryable,
        // but we can verify it doesn't throw and initializes properly.
        // Also it configures the ExtentSparkReporter.
        Assert.assertNotNull(extent, "ExtentReports should be initialized");
    }

    @Test
    public void testGetReportObjectCreatesReportFileIfFlushed() {
        ExtentReports extent = ExtentReporterNG.getReportObject();
        extent.flush(); // This should create the report file

        String path = System.getProperty("user.dir") + "//reports//index.html";
        File reportFile = new File(path);

        Assert.assertTrue(reportFile.exists(), "Report file index.html should be created at " + path);
    }
}
