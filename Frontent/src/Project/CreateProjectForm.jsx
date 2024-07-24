import React from "react";
import {
  FormField,
  Form,
  FormControl,
  FormMessage,
  FormItem,
} from "../components/ui/form";
import { Input } from "../components/ui/input"; // Assuming you have this component
import { useForm } from "react-hook-form";
import { DialogClose } from "@radix-ui/react-dialog";
import { Button } from "@/components/ui/button";
import { Select, SelectTrigger, SelectValue } from "@radix-ui/react-select";

const CreateProjectForm = () => {
  const form = useForm({
    defaultValues: {
      name: "",
      description: "", // Changed from 'Description' to 'description'
      category: "",
      tags: ["Javascript", "react"],
    },
  });

  const onSubmit = (data) => {
    console.log(data);
  };

  return (
    <div>
      <Form {...form}>
        <form className="space-y-3" onSubmit={form.handleSubmit(onSubmit)}>
          <FormField
            control={form.control}
            name="name"
            render={({ field }) => (
              <FormItem>
                <FormControl>
                  <Input
                    {...field}
                    type="text"
                    className="border w-full border-gray-700 py-5 px-5"
                    placeholder="Project name..."
                  />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="discription"
            render={({ field }) => (
              <FormItem>
                <FormControl>
                  <Input
                    {...field}
                    type="text"
                    className="border w-full border-gray-700 py-5 px-5"
                    placeholder="Project discription..."
                  />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="category"
            render={({ field }) => (
              <FormItem>
                <FormControl>
                  <Select
                    defaultValue="Fullstack "
                    value={field.value}
                    onValueChange={(value) => {
                      field.onChange(value);
                    }}
                  >
                    <SelectTrigger className="w-full ">
                      <SelectValue placeholder="Category"></SelectValue>
                    </SelectTrigger>
                  </Select>
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <DialogClose>
            {false ? (
              <div>
                <p>
                  you can create only 3 projects with free plan , please upgrade
                  your plan
                </p>
              </div>
            ) : (
              <Button type="submit" className="w-full my-3 ">
                Create Project
              </Button>
            )}
          </DialogClose>
        </form>
      </Form>
    </div>
  );
};
export default CreateProjectForm;
