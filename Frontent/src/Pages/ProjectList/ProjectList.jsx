import React, { useState } from "react";

import { Button } from "../../components/ui/button";
import {
  MagnifyingGlassIcon,
  MixerHorizontalIcon,
} from "@radix-ui/react-icons";
import { Card, CardContent } from "../../components/ui/card";
import { ScrollArea } from "../../components/ui/scroll-area";
import { RadioGroup, RadioGroupItem } from "../../components/ui/radio-group";
import { Label } from "../..//components/ui/label";
import { Input } from "../../components/ui/input";
import { ProjectCard } from "../../Project/ProjectCard";

export const ProjectList = () => {
  const [keyword, setKeyword] = useState("");

  const handleSearchChange = (e) => {
    if (e && e.target) {
      setKeyword(e.target.value);
    } else {
      console.error('Event or event.target is undefined');
    }
  };

  const handleFilterChange = (category, value) => {
    console.log("category", category, "value", value);
  };

  const tags = [
    "all",
    "react",
    "nextjs",
    "springboot",
    "mysql",
    "mongodb",
    "angular",
    "python",
    "flask",
    "django",
  ];

  // Placeholder for project data
  const projects = [1, 2, 3, 4, 5];

  return (
    <>
      <div className="relative px-5 lg:px-0 lg:flex gap-5 justify-center py-5">
        <section className="filterSection">
          <Card className="p-5 sticky top-10 border">
            <div className="flex lg:w-[20rem] justify-between">
              <p className="text-xl -teracking-wider">filters</p>
              <Button variant="ghost" size="icon">
                <MixerHorizontalIcon />
              </Button>
            </div>
            <CardContent className="mt-5">
              <ScrollArea className="space-y-7 h-[70vh]">
                <div>
                  <h1 className="pb-3 text-gray-400 border-b">Category</h1>
                  <div className="pt-5">
                    <RadioGroup
                      className="space-y-3 pt-5"
                      onValueChange={(value) =>
                        handleFilterChange("Category", value)
                      }
                    >
                      {["all", "fullstack", "frontend", "backend"].map((category) => (
                        <div key={category} className="flex gap-2 pb-2">
                          <RadioGroupItem value={category} id={`category-${category}`} />
                          <Label htmlFor={`category-${category}`}>{category}</Label>
                        </div>
                      ))}
                    </RadioGroup>
                  </div>
                </div>

                <div className="pt-9">
                  <h1 className="pb-3 text-gray-400 border-b">Tag</h1>
                  <div className="pt-5">
                    <RadioGroup
                      className="space-y-3 pt-5"
                      onValueChange={(value) =>
                        handleFilterChange("Tag", value)
                      }
                    >
                      {tags.map((item) => (
                        <div key={item} className="flex gap-2">
                          <RadioGroupItem value={item} id={`tag-${item}`} />
                          <Label htmlFor={`tag-${item}`}>{item}</Label>
                        </div>
                      ))}
                    </RadioGroup>
                  </div>
                </div>
              </ScrollArea>
            </CardContent>
          </Card>
        </section>

        <section className="projectListSection w-full lg:w-[48rem]">
          <div className="flex gap-2 items-center pb-5 justify-center">
            <div className="relative p-0 w-full">
              <Input
                onChange={handleSearchChange}
                className="40% px-9"
                placeholder="Search project"
              />
              <MagnifyingGlassIcon className="absolute top-3 left-4" />
            </div>
          </div>
          <div>
            <div className="space-y-5 min-h-[74vh]">
              {projects
                .filter(project => keyword ? /* add your search logic here */ true : true)
                .map((project) => (
                  <ProjectCard key={`project-${project}`} />
                ))
              }
            </div>
          </div>
        </section>
      </div>
    </>
  );
};